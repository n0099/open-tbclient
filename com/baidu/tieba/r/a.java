package com.baidu.tieba.r;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a jgH;
    private InterfaceC0393a jgI = cpn();

    /* renamed from: com.baidu.tieba.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0393a {
        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void f(Application application);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean cpm() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0393a cpn() {
        CustomResponsedMessage runTask;
        if (!cpm() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0393a.class)) == null) {
            return null;
        }
        return (InterfaceC0393a) runTask.getData();
    }

    public static a cpo() {
        if (jgH == null) {
            synchronized (a.class) {
                if (jgH == null) {
                    jgH = new a();
                }
            }
        }
        return jgH;
    }

    public void f(Application application) {
        if (this.jgI != null) {
            this.jgI.f(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.jgI != null) {
            this.jgI.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.jgI != null) {
            this.jgI.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.jgI != null) {
            this.jgI.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
