package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b mMt;
    private boolean mInited = false;
    private a mMu = dHb();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dHa() {
        return com.baidu.tbadk.core.sharedPref.b.blO().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dHb() {
        CustomResponsedMessage runTask;
        if (!dHa() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dHc() {
        if (mMt == null) {
            synchronized (b.class) {
                if (mMt == null) {
                    mMt = new b();
                }
            }
        }
        return mMt;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.mMu != null) {
            this.mMu.initSdk(application);
            this.mInited = true;
        }
    }
}
