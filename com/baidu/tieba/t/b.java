package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b mZc;
    private boolean mInited = false;
    private a mZd = dKj();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dKi() {
        return com.baidu.tbadk.core.sharedPref.b.bnH().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dKj() {
        CustomResponsedMessage runTask;
        if (!dKi() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dKk() {
        if (mZc == null) {
            synchronized (b.class) {
                if (mZc == null) {
                    mZc = new b();
                }
            }
        }
        return mZc;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.mZd != null) {
            this.mZd.initSdk(application);
            this.mInited = true;
        }
    }
}
