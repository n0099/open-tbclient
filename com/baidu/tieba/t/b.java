package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b mwJ;
    private boolean mInited = false;
    private a mwK = dDp();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dDo() {
        return com.baidu.tbadk.core.sharedPref.b.bjf().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dDp() {
        CustomResponsedMessage runTask;
        if (!dDo() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dDq() {
        if (mwJ == null) {
            synchronized (b.class) {
                if (mwJ == null) {
                    mwJ = new b();
                }
            }
        }
        return mwJ;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.mwK != null) {
            this.mwK.initSdk(application);
            this.mInited = true;
        }
    }
}
