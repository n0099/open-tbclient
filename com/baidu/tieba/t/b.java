package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b lVd;
    private boolean mInited = false;
    private a lVe = dnQ();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dnP() {
        return com.baidu.tbadk.core.sharedPref.b.aZP().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dnQ() {
        CustomResponsedMessage runTask;
        if (!dnP() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dnR() {
        if (lVd == null) {
            synchronized (b.class) {
                if (lVd == null) {
                    lVd = new b();
                }
            }
        }
        return lVd;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.lVe != null) {
            this.lVe.initSdk(application);
            this.mInited = true;
        }
    }
}
