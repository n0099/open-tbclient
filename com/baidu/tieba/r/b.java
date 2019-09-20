package com.baidu.tieba.r;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b jqv;
    private boolean mInited = false;
    private a jqw = ctj();

    /* loaded from: classes.dex */
    public interface a {
        void f(Application application);
    }

    private boolean cti() {
        return com.baidu.tbadk.core.sharedPref.b.ahU().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a ctj() {
        CustomResponsedMessage runTask;
        if (!cti() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b ctk() {
        if (jqv == null) {
            synchronized (b.class) {
                if (jqv == null) {
                    jqv = new b();
                }
            }
        }
        return jqv;
    }

    public void f(Application application) {
        if (!this.mInited && this.jqw != null) {
            this.jqw.f(application);
            this.mInited = true;
        }
    }
}
