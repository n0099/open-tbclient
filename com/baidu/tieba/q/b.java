package com.baidu.tieba.q;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b hjW;
    private boolean mInited = false;
    private a hjX = bEF();

    /* loaded from: classes.dex */
    public interface a {
        void b(Application application);
    }

    private boolean bEE() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a bEF() {
        CustomResponsedMessage runTask;
        if (!bEE() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b bEG() {
        if (hjW == null) {
            synchronized (b.class) {
                if (hjW == null) {
                    hjW = new b();
                }
            }
        }
        return hjW;
    }

    public void b(Application application) {
        if (!this.mInited && this.hjX != null) {
            this.hjX.b(application);
            this.mInited = true;
        }
    }

    public boolean bEH() {
        return this.mInited;
    }
}
