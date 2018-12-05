package com.baidu.tieba.q;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b hsT;
    private boolean mInited = false;
    private a hsU = bGi();

    /* loaded from: classes.dex */
    public interface a {
        void b(Application application);
    }

    private boolean bGh() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a bGi() {
        CustomResponsedMessage runTask;
        if (!bGh() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b bGj() {
        if (hsT == null) {
            synchronized (b.class) {
                if (hsT == null) {
                    hsT = new b();
                }
            }
        }
        return hsT;
    }

    public void b(Application application) {
        if (!this.mInited && this.hsU != null) {
            this.hsU.b(application);
            this.mInited = true;
        }
    }

    public boolean bGk() {
        return this.mInited;
    }
}
