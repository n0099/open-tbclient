package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b nAb;
    private boolean mInited = false;
    private a nAc = dSp();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dSo() {
        return com.baidu.tbadk.core.sharedPref.b.bvr().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dSp() {
        CustomResponsedMessage runTask;
        if (!dSo() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dSq() {
        if (nAb == null) {
            synchronized (b.class) {
                if (nAb == null) {
                    nAb = new b();
                }
            }
        }
        return nAb;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.nAc != null) {
            this.nAc.initSdk(application);
            this.mInited = true;
        }
    }
}
