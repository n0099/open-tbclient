package com.baidu.tieba.r;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a jqt;
    private InterfaceC0409a jqu = ctg();

    /* renamed from: com.baidu.tieba.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0409a {
        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void f(Application application);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean ctf() {
        return com.baidu.tbadk.core.sharedPref.b.ahU().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0409a ctg() {
        CustomResponsedMessage runTask;
        if (!ctf() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0409a.class)) == null) {
            return null;
        }
        return (InterfaceC0409a) runTask.getData();
    }

    public static a cth() {
        if (jqt == null) {
            synchronized (a.class) {
                if (jqt == null) {
                    jqt = new a();
                }
            }
        }
        return jqt;
    }

    public void f(Application application) {
        if (this.jqu != null) {
            this.jqu.f(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.jqu != null) {
            this.jqu.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.jqu != null) {
            this.jqu.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.jqu != null) {
            this.jqu.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
