package com.baidu.tieba.u;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b nfZ;
    private boolean mInited = false;
    private a nga = dMK();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dMJ() {
        return com.baidu.tbadk.core.sharedPref.b.bpu().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dMK() {
        CustomResponsedMessage runTask;
        if (!dMJ() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dML() {
        if (nfZ == null) {
            synchronized (b.class) {
                if (nfZ == null) {
                    nfZ = new b();
                }
            }
        }
        return nfZ;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.nga != null) {
            this.nga.initSdk(application);
            this.mInited = true;
        }
    }
}
