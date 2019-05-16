package com.baidu.tieba.r;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a jgC;
    private InterfaceC0393a jgD = cpk();

    /* renamed from: com.baidu.tieba.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0393a {
        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void f(Application application);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean cpj() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0393a cpk() {
        CustomResponsedMessage runTask;
        if (!cpj() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0393a.class)) == null) {
            return null;
        }
        return (InterfaceC0393a) runTask.getData();
    }

    public static a cpl() {
        if (jgC == null) {
            synchronized (a.class) {
                if (jgC == null) {
                    jgC = new a();
                }
            }
        }
        return jgC;
    }

    public void f(Application application) {
        if (this.jgD != null) {
            this.jgD.f(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.jgD != null) {
            this.jgD.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.jgD != null) {
            this.jgD.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.jgD != null) {
            this.jgD.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
