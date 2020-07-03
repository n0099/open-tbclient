package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b lNN;
    private boolean mInited = false;
    private a lNO = dkD();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dkC() {
        return com.baidu.tbadk.core.sharedPref.b.aVP().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dkD() {
        CustomResponsedMessage runTask;
        if (!dkC() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dkE() {
        if (lNN == null) {
            synchronized (b.class) {
                if (lNN == null) {
                    lNN = new b();
                }
            }
        }
        return lNN;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.lNO != null) {
            this.lNO.initSdk(application);
            this.mInited = true;
        }
    }
}
