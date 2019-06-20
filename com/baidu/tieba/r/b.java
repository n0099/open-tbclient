package com.baidu.tieba.r;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b jgJ;
    private boolean mInited = false;
    private a jgK = cpq();

    /* loaded from: classes.dex */
    public interface a {
        void f(Application application);
    }

    private boolean cpp() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a cpq() {
        CustomResponsedMessage runTask;
        if (!cpp() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b cpr() {
        if (jgJ == null) {
            synchronized (b.class) {
                if (jgJ == null) {
                    jgJ = new b();
                }
            }
        }
        return jgJ;
    }

    public void f(Application application) {
        if (!this.mInited && this.jgK != null) {
            this.jgK.f(application);
            this.mInited = true;
        }
    }
}
