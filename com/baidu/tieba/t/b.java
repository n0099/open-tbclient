package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b lVf;
    private boolean mInited = false;
    private a lVg = dnR();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dnQ() {
        return com.baidu.tbadk.core.sharedPref.b.aZP().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dnR() {
        CustomResponsedMessage runTask;
        if (!dnQ() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dnS() {
        if (lVf == null) {
            synchronized (b.class) {
                if (lVf == null) {
                    lVf = new b();
                }
            }
        }
        return lVf;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.lVg != null) {
            this.lVg.initSdk(application);
            this.mInited = true;
        }
    }
}
