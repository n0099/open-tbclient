package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b lam;
    private boolean mInited = false;
    private a lan = cYR();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean cYQ() {
        return com.baidu.tbadk.core.sharedPref.b.aNT().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a cYR() {
        CustomResponsedMessage runTask;
        if (!cYQ() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b cYS() {
        if (lam == null) {
            synchronized (b.class) {
                if (lam == null) {
                    lam = new b();
                }
            }
        }
        return lam;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.lan != null) {
            this.lan.initSdk(application);
            this.mInited = true;
        }
    }
}
