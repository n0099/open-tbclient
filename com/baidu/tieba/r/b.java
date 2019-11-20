package com.baidu.tieba.r;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b jpw;
    private boolean mInited = false;
    private a jpx = cqW();

    /* loaded from: classes.dex */
    public interface a {
        void g(Application application);
    }

    private boolean cqV() {
        return com.baidu.tbadk.core.sharedPref.b.alP().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a cqW() {
        CustomResponsedMessage runTask;
        if (!cqV() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b cqX() {
        if (jpw == null) {
            synchronized (b.class) {
                if (jpw == null) {
                    jpw = new b();
                }
            }
        }
        return jpw;
    }

    public void g(Application application) {
        if (!this.mInited && this.jpx != null) {
            this.jpx.g(application);
            this.mInited = true;
        }
    }
}
