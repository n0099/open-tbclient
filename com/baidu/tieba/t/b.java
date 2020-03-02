package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b kon;
    private boolean mInited = false;
    private a koo = cNC();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean cNB() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a cNC() {
        CustomResponsedMessage runTask;
        if (!cNB() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b cND() {
        if (kon == null) {
            synchronized (b.class) {
                if (kon == null) {
                    kon = new b();
                }
            }
        }
        return kon;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.koo != null) {
            this.koo.initSdk(application);
            this.mInited = true;
        }
    }
}
