package com.baidu.tieba.r;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b iNL;
    private boolean mInited = false;
    private a iNM = chj();

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
        if (iNL == null) {
            synchronized (b.class) {
                if (iNL == null) {
                    iNL = new b();
                }
            }
        }
        return iNL;
    }

    public void d(Application application) {
        if (!this.mInited && this.iNM != null) {
            this.iNM.d(application);
            this.mInited = true;
        }
    }

    public boolean chl() {
        return this.mInited;
    }
}
