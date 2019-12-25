package com.baidu.tieba.s;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b kjG;
    private boolean mInited = false;
    private a kjH = cKY();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean cKX() {
        return com.baidu.tbadk.core.sharedPref.b.aCY().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a cKY() {
        CustomResponsedMessage runTask;
        if (!cKX() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b cKZ() {
        if (kjG == null) {
            synchronized (b.class) {
                if (kjG == null) {
                    kjG = new b();
                }
            }
        }
        return kjG;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.kjH != null) {
            this.kjH.initSdk(application);
            this.mInited = true;
        }
    }
}
