package com.baidu.tieba.r;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b iNW;
    private boolean mInited = false;
    private a iNX = chl();

    /* loaded from: classes.dex */
    public interface a {
        void d(Application application);
    }

    private boolean chk() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a chl() {
        CustomResponsedMessage runTask;
        if (!chk() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b chm() {
        if (iNW == null) {
            synchronized (b.class) {
                if (iNW == null) {
                    iNW = new b();
                }
            }
        }
        return iNW;
    }

    public void d(Application application) {
        if (!this.mInited && this.iNX != null) {
            this.iNX.d(application);
            this.mInited = true;
        }
    }

    public boolean chn() {
        return this.mInited;
    }
}
