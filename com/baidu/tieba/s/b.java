package com.baidu.tieba.s;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b kno;
    private boolean mInited = false;
    private a knp = cMf();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean cMe() {
        return com.baidu.tbadk.core.sharedPref.b.aDr().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a cMf() {
        CustomResponsedMessage runTask;
        if (!cMe() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b cMg() {
        if (kno == null) {
            synchronized (b.class) {
                if (kno == null) {
                    kno = new b();
                }
            }
        }
        return kno;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.knp != null) {
            this.knp.initSdk(application);
            this.mInited = true;
        }
    }
}
