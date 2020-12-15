package com.baidu.tieba.u;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b nuf;
    private boolean mInited = false;
    private a nug = dSd();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dSc() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dSd() {
        CustomResponsedMessage runTask;
        if (!dSc() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dSe() {
        if (nuf == null) {
            synchronized (b.class) {
                if (nuf == null) {
                    nuf = new b();
                }
            }
        }
        return nuf;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.nug != null) {
            this.nug.initSdk(application);
            this.mInited = true;
        }
    }
}
