package com.baidu.tieba.q;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a gPp;
    private InterfaceC0220a gPq = bzt();

    /* renamed from: com.baidu.tieba.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0220a {
        void A(Activity activity);

        void b(Application application);

        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void onResume(Activity activity);
    }

    private boolean bzs() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0220a bzt() {
        CustomResponsedMessage runTask;
        if (!bzs() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0220a.class)) == null) {
            return null;
        }
        return (InterfaceC0220a) runTask.getData();
    }

    public static a bzu() {
        if (gPp == null) {
            synchronized (a.class) {
                if (gPp == null) {
                    gPp = new a();
                }
            }
        }
        return gPp;
    }

    public void b(Application application) {
        if (this.gPq != null) {
            this.gPq.b(application);
        }
    }

    public void A(Activity activity) {
        if (this.gPq != null) {
            this.gPq.A(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.gPq != null) {
            this.gPq.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.gPq != null) {
            this.gPq.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
