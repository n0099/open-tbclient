package com.baidu.tieba.r;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b jmT;
    private boolean mInited = false;
    private a jmU = crZ();

    /* loaded from: classes.dex */
    public interface a {
        void f(Application application);
    }

    private boolean crY() {
        return com.baidu.tbadk.core.sharedPref.b.ahO().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a crZ() {
        CustomResponsedMessage runTask;
        if (!crY() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b csa() {
        if (jmT == null) {
            synchronized (b.class) {
                if (jmT == null) {
                    jmT = new b();
                }
            }
        }
        return jmT;
    }

    public void f(Application application) {
        if (!this.mInited && this.jmU != null) {
            this.jmU.f(application);
            this.mInited = true;
        }
    }
}
