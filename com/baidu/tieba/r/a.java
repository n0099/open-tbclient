package com.baidu.tieba.r;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a hwd;
    private InterfaceC0303a hwe = bGU();

    /* renamed from: com.baidu.tieba.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0303a {
        void b(Application application);

        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean bGT() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0303a bGU() {
        CustomResponsedMessage runTask;
        if (!bGT() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0303a.class)) == null) {
            return null;
        }
        return (InterfaceC0303a) runTask.getData();
    }

    public static a bGV() {
        if (hwd == null) {
            synchronized (a.class) {
                if (hwd == null) {
                    hwd = new a();
                }
            }
        }
        return hwd;
    }

    public void b(Application application) {
        if (this.hwe != null) {
            this.hwe.b(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.hwe != null) {
            this.hwe.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.hwe != null) {
            this.hwe.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.hwe != null) {
            this.hwe.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
