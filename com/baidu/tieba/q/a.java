package com.baidu.tieba.q;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a hcD;
    private InterfaceC0228a hcE = bBo();

    /* renamed from: com.baidu.tieba.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0228a {
        void b(Application application);

        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean bBn() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0228a bBo() {
        CustomResponsedMessage runTask;
        if (!bBn() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0228a.class)) == null) {
            return null;
        }
        return (InterfaceC0228a) runTask.getData();
    }

    public static a bBp() {
        if (hcD == null) {
            synchronized (a.class) {
                if (hcD == null) {
                    hcD = new a();
                }
            }
        }
        return hcD;
    }

    public void b(Application application) {
        if (this.hcE != null) {
            this.hcE.b(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.hcE != null) {
            this.hcE.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.hcE != null) {
            this.hcE.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.hcE != null) {
            this.hcE.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
