package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b koz;
    private boolean mInited = false;
    private a koA = cND();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean cNC() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a cND() {
        CustomResponsedMessage runTask;
        if (!cNC() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b cNE() {
        if (koz == null) {
            synchronized (b.class) {
                if (koz == null) {
                    koz = new b();
                }
            }
        }
        return koz;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.koA != null) {
            this.koA.initSdk(application);
            this.mInited = true;
        }
    }
}
