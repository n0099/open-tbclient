package com.baidu.tieba.q;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a hjU;
    private InterfaceC0262a hjV = bEC();

    /* renamed from: com.baidu.tieba.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0262a {
        void b(Application application);

        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean bEB() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0262a bEC() {
        CustomResponsedMessage runTask;
        if (!bEB() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0262a.class)) == null) {
            return null;
        }
        return (InterfaceC0262a) runTask.getData();
    }

    public static a bED() {
        if (hjU == null) {
            synchronized (a.class) {
                if (hjU == null) {
                    hjU = new a();
                }
            }
        }
        return hjU;
    }

    public void b(Application application) {
        if (this.hjV != null) {
            this.hjV.b(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.hjV != null) {
            this.hjV.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.hjV != null) {
            this.hjV.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.hjV != null) {
            this.hjV.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
