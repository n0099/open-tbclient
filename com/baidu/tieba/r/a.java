package com.baidu.tieba.r;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a jql;
    private InterfaceC0503a jqm = cqV();

    /* renamed from: com.baidu.tieba.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0503a {
        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void g(Application application);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean cqU() {
        return com.baidu.tbadk.core.sharedPref.b.alR().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0503a cqV() {
        CustomResponsedMessage runTask;
        if (!cqU() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0503a.class)) == null) {
            return null;
        }
        return (InterfaceC0503a) runTask.getData();
    }

    public static a cqW() {
        if (jql == null) {
            synchronized (a.class) {
                if (jql == null) {
                    jql = new a();
                }
            }
        }
        return jql;
    }

    public void g(Application application) {
        if (this.jqm != null) {
            this.jqm.g(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.jqm != null) {
            this.jqm.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.jqm != null) {
            this.jqm.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.jqm != null) {
            this.jqm.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
