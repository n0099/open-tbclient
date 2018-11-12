package com.baidu.tieba.q;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a hlF;
    private InterfaceC0290a hlG = bEb();

    /* renamed from: com.baidu.tieba.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0290a {
        void b(Application application);

        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean bEa() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0290a bEb() {
        CustomResponsedMessage runTask;
        if (!bEa() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0290a.class)) == null) {
            return null;
        }
        return (InterfaceC0290a) runTask.getData();
    }

    public static a bEc() {
        if (hlF == null) {
            synchronized (a.class) {
                if (hlF == null) {
                    hlF = new a();
                }
            }
        }
        return hlF;
    }

    public void b(Application application) {
        if (this.hlG != null) {
            this.hlG.b(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.hlG != null) {
            this.hlG.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.hlG != null) {
            this.hlG.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.hlG != null) {
            this.hlG.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
