package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b lNQ;
    private boolean mInited = false;
    private a lNR = dkH();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dkG() {
        return com.baidu.tbadk.core.sharedPref.b.aVP().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dkH() {
        CustomResponsedMessage runTask;
        if (!dkG() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dkI() {
        if (lNQ == null) {
            synchronized (b.class) {
                if (lNQ == null) {
                    lNQ = new b();
                }
            }
        }
        return lNQ;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.lNR != null) {
            this.lNR.initSdk(application);
            this.mInited = true;
        }
    }
}
