package com.baidu.tieba.q;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {
    private static b hlH;
    private boolean mInited = false;
    private a hlI = bEe();

    /* loaded from: classes.dex */
    public interface a {
        void b(Application application);
    }

    private boolean bEd() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_jpush_sdk_enable", 0) == 1;
    }

    private b() {
    }

    private a bEe() {
        CustomResponsedMessage runTask;
        if (!bEd() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static b bEf() {
        if (hlH == null) {
            synchronized (b.class) {
                if (hlH == null) {
                    hlH = new b();
                }
            }
        }
        return hlH;
    }

    public void b(Application application) {
        if (!this.mInited && this.hlI != null) {
            this.hlI.b(application);
            this.mInited = true;
        }
    }

    public boolean bEg() {
        return this.mInited;
    }
}
