package com.baidu.tieba.r;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b iNK;
    private boolean mInited = false;
    private a iNL = chj();

    /* loaded from: classes.dex */
    public interface a {
        void d(Application application);
    }

    private boolean chi() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a chj() {
        CustomResponsedMessage runTask;
        if (!chi() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b chk() {
        if (iNK == null) {
            synchronized (b.class) {
                if (iNK == null) {
                    iNK = new b();
                }
            }
        }
        return iNK;
    }

    public void d(Application application) {
        if (!this.mInited && this.iNL != null) {
            this.iNL.d(application);
            this.mInited = true;
        }
    }

    public boolean chl() {
        return this.mInited;
    }
}
