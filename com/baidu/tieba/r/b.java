package com.baidu.tieba.r;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b hxm;
    private boolean mInited = false;
    private a hxn = bHG();

    /* loaded from: classes.dex */
    public interface a {
        void b(Application application);
    }

    private boolean bHF() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a bHG() {
        CustomResponsedMessage runTask;
        if (!bHF() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b bHH() {
        if (hxm == null) {
            synchronized (b.class) {
                if (hxm == null) {
                    hxm = new b();
                }
            }
        }
        return hxm;
    }

    public void b(Application application) {
        if (!this.mInited && this.hxn != null) {
            this.hxn.b(application);
            this.mInited = true;
        }
    }

    public boolean bHI() {
        return this.mInited;
    }
}
