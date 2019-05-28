package com.baidu.tieba.r;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b jgF;
    private boolean mInited = false;
    private a jgG = cpp();

    /* loaded from: classes.dex */
    public interface a {
        void f(Application application);
    }

    private boolean cpo() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a cpp() {
        CustomResponsedMessage runTask;
        if (!cpo() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b cpq() {
        if (jgF == null) {
            synchronized (b.class) {
                if (jgF == null) {
                    jgF = new b();
                }
            }
        }
        return jgF;
    }

    public void f(Application application) {
        if (!this.mInited && this.jgG != null) {
            this.jgG.f(application);
            this.mInited = true;
        }
    }
}
