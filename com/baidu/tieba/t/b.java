package com.baidu.tieba.t;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes2.dex */
public class b {
    private static b mmS;
    private boolean mInited = false;
    private a mmT = dzm();

    /* loaded from: classes2.dex */
    public interface a {
        void initSdk(Application application);
    }

    private boolean dzl() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a dzm() {
        CustomResponsedMessage runTask;
        if (!dzl() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b dzn() {
        if (mmS == null) {
            synchronized (b.class) {
                if (mmS == null) {
                    mmS = new b();
                }
            }
        }
        return mmS;
    }

    public void initSdk(Application application) {
        if (!this.mInited && this.mmT != null) {
            this.mmT.initSdk(application);
            this.mInited = true;
        }
    }
}
