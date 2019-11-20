package com.baidu.tieba.r;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a jpu;
    private InterfaceC0503a jpv = cqT();

    /* renamed from: com.baidu.tieba.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0503a {
        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void g(Application application);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean cqS() {
        return com.baidu.tbadk.core.sharedPref.b.alP().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0503a cqT() {
        CustomResponsedMessage runTask;
        if (!cqS() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0503a.class)) == null) {
            return null;
        }
        return (InterfaceC0503a) runTask.getData();
    }

    public static a cqU() {
        if (jpu == null) {
            synchronized (a.class) {
                if (jpu == null) {
                    jpu = new a();
                }
            }
        }
        return jpu;
    }

    public void g(Application application) {
        if (this.jpv != null) {
            this.jpv.g(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.jpv != null) {
            this.jpv.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.jpv != null) {
            this.jpv.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.jpv != null) {
            this.jpv.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
