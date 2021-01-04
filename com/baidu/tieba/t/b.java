package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b nAc;
    private boolean mInited = false;
    private a nAd = dSo();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dSn() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dSo() {
        CustomResponsedMessage runTask;
        if (!dSn() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dSp() {
        if (nAc == null) {
            synchronized (b.class) {
                if (nAc == null) {
                    nAc = new b();
                }
            }
        }
        return nAc;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.nAd != null) {
            this.nAd.initSdk(application);
            this.mInited = true;
        }
    }
}
