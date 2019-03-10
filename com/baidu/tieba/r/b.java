package com.baidu.tieba.r;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b iOe;
    private boolean mInited = false;
    private a iOf = chi();

    /* loaded from: classes.dex */
    public interface a {
        void d(Application application);
    }

    private boolean chh() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a chi() {
        CustomResponsedMessage runTask;
        if (!chh() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b chj() {
        if (iOe == null) {
            synchronized (b.class) {
                if (iOe == null) {
                    iOe = new b();
                }
            }
        }
        return iOe;
    }

    public void d(Application application) {
        if (!this.mInited && this.iOf != null) {
            this.iOf.d(application);
            this.mInited = true;
        }
    }

    public boolean chk() {
        return this.mInited;
    }
}
