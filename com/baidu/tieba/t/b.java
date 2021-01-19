package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b nvx;
    private boolean mInited = false;
    private a nvy = dOx();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dOw() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dOx() {
        CustomResponsedMessage runTask;
        if (!dOw() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dOy() {
        if (nvx == null) {
            synchronized (b.class) {
                if (nvx == null) {
                    nvx = new b();
                }
            }
        }
        return nvx;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.nvy != null) {
            this.nvy.initSdk(application);
            this.mInited = true;
        }
    }
}
