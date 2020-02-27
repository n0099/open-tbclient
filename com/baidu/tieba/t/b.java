package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b kol;
    private boolean mInited = false;
    private a kom = cNA();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean cNz() {
        return com.baidu.tbadk.core.sharedPref.b.aFB().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a cNA() {
        CustomResponsedMessage runTask;
        if (!cNz() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b cNB() {
        if (kol == null) {
            synchronized (b.class) {
                if (kol == null) {
                    kol = new b();
                }
            }
        }
        return kol;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.kom != null) {
            this.kom.initSdk(application);
            this.mInited = true;
        }
    }
}
