package com.baidu.tieba.q;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b hjX;
    private boolean mInited = false;
    private a hjY = bEF();

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
        if (hjX == null) {
            synchronized (b.class) {
                if (hjX == null) {
                    hjX = new b();
                }
            }
        }
        return hjX;
    }

    public void b(Application application) {
        if (!this.mInited && this.hjY != null) {
            this.hjY.b(application);
            this.mInited = true;
        }
    }

    public boolean bEH() {
        return this.mInited;
    }
}
