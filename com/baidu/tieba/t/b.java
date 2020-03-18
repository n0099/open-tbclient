package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b kqd;
    private boolean mInited = false;
    private a kqe = cNX();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean cNW() {
        return com.baidu.tbadk.core.sharedPref.b.aFH().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a cNX() {
        CustomResponsedMessage runTask;
        if (!cNW() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b cNY() {
        if (kqd == null) {
            synchronized (b.class) {
                if (kqd == null) {
                    kqd = new b();
                }
            }
        }
        return kqd;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.kqe != null) {
            this.kqe.initSdk(application);
            this.mInited = true;
        }
    }
}
