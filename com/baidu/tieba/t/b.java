package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b lug;
    private boolean mInited = false;
    private a luh = dgv();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dgu() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dgv() {
        CustomResponsedMessage runTask;
        if (!dgu() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dgw() {
        if (lug == null) {
            synchronized (b.class) {
                if (lug == null) {
                    lug = new b();
                }
            }
        }
        return lug;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.luh != null) {
            this.luh.initSdk(application);
            this.mInited = true;
        }
    }
}
