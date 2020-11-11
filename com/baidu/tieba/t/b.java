package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b neY;
    private boolean mInited = false;
    private a neZ = dML();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dMK() {
        return com.baidu.tbadk.core.sharedPref.b.bqh().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dML() {
        CustomResponsedMessage runTask;
        if (!dMK() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dMM() {
        if (neY == null) {
            synchronized (b.class) {
                if (neY == null) {
                    neY = new b();
                }
            }
        }
        return neY;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.neZ != null) {
            this.neZ.initSdk(application);
            this.mInited = true;
        }
    }
}
