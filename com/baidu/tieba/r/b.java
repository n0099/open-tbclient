package com.baidu.tieba.r;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b jgE;
    private boolean mInited = false;
    private a jgF = cpn();

    /* loaded from: classes.dex */
    public interface a {
        void f(Application application);
    }

    private boolean cpm() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a cpn() {
        CustomResponsedMessage runTask;
        if (!cpm() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b cpo() {
        if (jgE == null) {
            synchronized (b.class) {
                if (jgE == null) {
                    jgE = new b();
                }
            }
        }
        return jgE;
    }

    public void f(Application application) {
        if (!this.mInited && this.jgF != null) {
            this.jgF.f(application);
            this.mInited = true;
        }
    }
}
