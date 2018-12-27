package com.baidu.tieba.r;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b hwf;
    private boolean mInited = false;
    private a hwg = bGX();

    /* loaded from: classes.dex */
    public interface a {
        void b(Application application);
    }

    private boolean bGW() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a bGX() {
        CustomResponsedMessage runTask;
        if (!bGW() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b bGY() {
        if (hwf == null) {
            synchronized (b.class) {
                if (hwf == null) {
                    hwf = new b();
                }
            }
        }
        return hwf;
    }

    public void b(Application application) {
        if (!this.mInited && this.hwg != null) {
            this.hwg.b(application);
            this.mInited = true;
        }
    }

    public boolean bGZ() {
        return this.mInited;
    }
}
