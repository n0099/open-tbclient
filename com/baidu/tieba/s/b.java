package com.baidu.tieba.s;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b knj;
    private boolean mInited = false;
    private a knk = cMd();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean cMc() {
        return com.baidu.tbadk.core.sharedPref.b.aDr().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a cMd() {
        CustomResponsedMessage runTask;
        if (!cMc() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b cMe() {
        if (knj == null) {
            synchronized (b.class) {
                if (knj == null) {
                    knj = new b();
                }
            }
        }
        return knj;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.knk != null) {
            this.knk.initSdk(application);
            this.mInited = true;
        }
    }
}
