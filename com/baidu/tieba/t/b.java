package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b nFh;
    private boolean mInited = false;
    private a nFi = dQI();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dQH() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dQI() {
        CustomResponsedMessage runTask;
        if (!dQH() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dQJ() {
        if (nFh == null) {
            synchronized (b.class) {
                if (nFh == null) {
                    nFh = new b();
                }
            }
        }
        return nFh;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.nFi != null) {
            this.nFi.initSdk(application);
            this.mInited = true;
        }
    }
}
