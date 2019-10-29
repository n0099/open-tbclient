package com.baidu.tieba.r;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b jqn;
    private boolean mInited = false;
    private a jqo = cqY();

    /* loaded from: classes.dex */
    public interface a {
        void g(Application application);
    }

    private boolean cqX() {
        return com.baidu.tbadk.core.sharedPref.b.alR().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a cqY() {
        CustomResponsedMessage runTask;
        if (!cqX() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b cqZ() {
        if (jqn == null) {
            synchronized (b.class) {
                if (jqn == null) {
                    jqn = new b();
                }
            }
        }
        return jqn;
    }

    public void g(Application application) {
        if (!this.mInited && this.jqo != null) {
            this.jqo.g(application);
            this.mInited = true;
        }
    }
}
