package com.baidu.tieba.r;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a iOc;
    private InterfaceC0298a iOd = chf();

    /* renamed from: com.baidu.tieba.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0298a {
        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void d(Application application);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean che() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0298a chf() {
        CustomResponsedMessage runTask;
        if (!che() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0298a.class)) == null) {
            return null;
        }
        return (InterfaceC0298a) runTask.getData();
    }

    public static a chg() {
        if (iOc == null) {
            synchronized (a.class) {
                if (iOc == null) {
                    iOc = new a();
                }
            }
        }
        return iOc;
    }

    public void d(Application application) {
        if (this.iOd != null) {
            this.iOd.d(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.iOd != null) {
            this.iOd.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.iOd != null) {
            this.iOd.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.iOd != null) {
            this.iOd.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
