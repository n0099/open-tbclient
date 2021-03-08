package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b nHN;
    private boolean mInited = false;
    private a nHO = dQZ();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dQY() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dQZ() {
        CustomResponsedMessage runTask;
        if (!dQY() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dRa() {
        if (nHN == null) {
            synchronized (b.class) {
                if (nHN == null) {
                    nHN = new b();
                }
            }
        }
        return nHN;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.nHO != null) {
            this.nHO.initSdk(application);
            this.mInited = true;
        }
    }
}
