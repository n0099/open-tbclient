package com.baidu.tieba.r;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b joa;
    private boolean mInited = false;
    private a job = csv();

    /* loaded from: classes.dex */
    public interface a {
        void f(Application application);
    }

    private boolean csu() {
        return com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a csv() {
        CustomResponsedMessage runTask;
        if (!csu() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b csw() {
        if (joa == null) {
            synchronized (b.class) {
                if (joa == null) {
                    joa = new b();
                }
            }
        }
        return joa;
    }

    public void f(Application application) {
        if (!this.mInited && this.job != null) {
            this.job.f(application);
            this.mInited = true;
        }
    }
}
