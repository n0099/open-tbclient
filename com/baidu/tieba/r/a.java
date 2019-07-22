package com.baidu.tieba.r;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a jmR;
    private InterfaceC0392a jmS = crW();

    /* renamed from: com.baidu.tieba.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0392a {
        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void f(Application application);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean crV() {
        return com.baidu.tbadk.core.sharedPref.b.ahO().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0392a crW() {
        CustomResponsedMessage runTask;
        if (!crV() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0392a.class)) == null) {
            return null;
        }
        return (InterfaceC0392a) runTask.getData();
    }

    public static a crX() {
        if (jmR == null) {
            synchronized (a.class) {
                if (jmR == null) {
                    jmR = new a();
                }
            }
        }
        return jmR;
    }

    public void f(Application application) {
        if (this.jmS != null) {
            this.jmS.f(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.jmS != null) {
            this.jmS.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.jmS != null) {
            this.jmS.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.jmS != null) {
            this.jmS.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
