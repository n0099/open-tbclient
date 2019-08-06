package com.baidu.tieba.r;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a jnY;
    private InterfaceC0398a jnZ = css();

    /* renamed from: com.baidu.tieba.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0398a {
        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void f(Application application);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean csr() {
        return com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0398a css() {
        CustomResponsedMessage runTask;
        if (!csr() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0398a.class)) == null) {
            return null;
        }
        return (InterfaceC0398a) runTask.getData();
    }

    public static a cst() {
        if (jnY == null) {
            synchronized (a.class) {
                if (jnY == null) {
                    jnY = new a();
                }
            }
        }
        return jnY;
    }

    public void f(Application application) {
        if (this.jnZ != null) {
            this.jnZ.f(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.jnZ != null) {
            this.jnZ.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.jnZ != null) {
            this.jnZ.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.jnZ != null) {
            this.jnZ.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
