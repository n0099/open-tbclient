package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b mnk;
    private boolean mInited = false;
    private a mnl = dzv();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dzu() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dzv() {
        CustomResponsedMessage runTask;
        if (!dzu() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dzw() {
        if (mnk == null) {
            synchronized (b.class) {
                if (mnk == null) {
                    mnk = new b();
                }
            }
        }
        return mnk;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.mnl != null) {
            this.mnl.initSdk(application);
            this.mInited = true;
        }
    }
}
