package com.baidu.tieba.q;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b hcF;
    private boolean mInited = false;
    private a hcG = bBr();

    /* loaded from: classes.dex */
    public interface a {
        void b(Application application);
    }

    private boolean bBq() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a bBr() {
        CustomResponsedMessage runTask;
        if (!bBq() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b bBs() {
        if (hcF == null) {
            synchronized (b.class) {
                if (hcF == null) {
                    hcF = new b();
                }
            }
        }
        return hcF;
    }

    public void b(Application application) {
        if (!this.mInited && this.hcG != null) {
            this.hcG.b(application);
            this.mInited = true;
        }
    }

    public boolean bBt() {
        return this.mInited;
    }
}
