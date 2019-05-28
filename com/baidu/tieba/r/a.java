package com.baidu.tieba.r;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a jgD;
    private InterfaceC0393a jgE = cpm();

    /* renamed from: com.baidu.tieba.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0393a {
        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void f(Application application);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean cpl() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0393a cpm() {
        CustomResponsedMessage runTask;
        if (!cpl() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0393a.class)) == null) {
            return null;
        }
        return (InterfaceC0393a) runTask.getData();
    }

    public static a cpn() {
        if (jgD == null) {
            synchronized (a.class) {
                if (jgD == null) {
                    jgD = new a();
                }
            }
        }
        return jgD;
    }

    public void f(Application application) {
        if (this.jgE != null) {
            this.jgE.f(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.jgE != null) {
            this.jgE.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.jgE != null) {
            this.jgE.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.jgE != null) {
            this.jgE.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
