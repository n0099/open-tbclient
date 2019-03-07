package com.baidu.tieba.r;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b iNK;
    private boolean mInited = false;
    private a iNL = cgY();

    /* loaded from: classes.dex */
    public interface a {
        void d(Application application);
    }

    private boolean cgX() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a cgY() {
        CustomResponsedMessage runTask;
        if (!cgX() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b cgZ() {
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

    public boolean cha() {
        return this.mInited;
    }
}
