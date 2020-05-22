package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b lsW;
    private boolean mInited = false;
    private a lsX = dgg();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dgf() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dgg() {
        CustomResponsedMessage runTask;
        if (!dgf() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dgh() {
        if (lsW == null) {
            synchronized (b.class) {
                if (lsW == null) {
                    lsW = new b();
                }
            }
        }
        return lsW;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.lsX != null) {
            this.lsX.initSdk(application);
            this.mInited = true;
        }
    }
}
