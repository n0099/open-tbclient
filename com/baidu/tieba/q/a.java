package com.baidu.tieba.q;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a gTQ;
    private InterfaceC0222a gTR = bAb();

    /* renamed from: com.baidu.tieba.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0222a {
        void A(Activity activity);

        void b(Application application);

        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void onResume(Activity activity);
    }

    private boolean bAa() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0222a bAb() {
        CustomResponsedMessage runTask;
        if (!bAa() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0222a.class)) == null) {
            return null;
        }
        return (InterfaceC0222a) runTask.getData();
    }

    public static a bAc() {
        if (gTQ == null) {
            synchronized (a.class) {
                if (gTQ == null) {
                    gTQ = new a();
                }
            }
        }
        return gTQ;
    }

    public void b(Application application) {
        if (this.gTR != null) {
            this.gTR.b(application);
        }
    }

    public void A(Activity activity) {
        if (this.gTR != null) {
            this.gTR.A(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.gTR != null) {
            this.gTR.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.gTR != null) {
            this.gTR.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
