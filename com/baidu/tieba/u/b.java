package com.baidu.tieba.u;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b nud;
    private boolean mInited = false;
    private a nue = dSc();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dSb() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dSc() {
        CustomResponsedMessage runTask;
        if (!dSb() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dSd() {
        if (nud == null) {
            synchronized (b.class) {
                if (nud == null) {
                    nud = new b();
                }
            }
        }
        return nud;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.nue != null) {
            this.nue.initSdk(application);
            this.mInited = true;
        }
    }
}
