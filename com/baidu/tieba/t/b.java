package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b lai;
    private boolean mInited = false;
    private a laj = cYU();

    /* loaded from: classes.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean cYT() {
        return com.baidu.tbadk.core.sharedPref.b.aNV().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a cYU() {
        CustomResponsedMessage runTask;
        if (!cYT() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b cYV() {
        if (lai == null) {
            synchronized (b.class) {
                if (lai == null) {
                    lai = new b();
                }
            }
        }
        return lai;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.laj != null) {
            this.laj.initSdk(application);
            this.mInited = true;
        }
    }
}
