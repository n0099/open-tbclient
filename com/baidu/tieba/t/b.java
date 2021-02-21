package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b nFH;
    private boolean mInited = false;
    private a nFI = dQQ();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dQP() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dQQ() {
        CustomResponsedMessage runTask;
        if (!dQP() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dQR() {
        if (nFH == null) {
            synchronized (b.class) {
                if (nFH == null) {
                    nFH = new b();
                }
            }
        }
        return nFH;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.nFI != null) {
            this.nFI.initSdk(application);
            this.mInited = true;
        }
    }
}
