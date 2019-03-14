package com.baidu.tieba.r;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a iNU;
    private InterfaceC0374a iNV = chi();

    /* renamed from: com.baidu.tieba.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0374a {
        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void d(Application application);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean chh() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0374a chi() {
        CustomResponsedMessage runTask;
        if (!chh() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0374a.class)) == null) {
            return null;
        }
        return (InterfaceC0374a) runTask.getData();
    }

    public static a chj() {
        if (iNU == null) {
            synchronized (a.class) {
                if (iNU == null) {
                    iNU = new a();
                }
            }
        }
        return iNU;
    }

    public void d(Application application) {
        if (this.iNV != null) {
            this.iNV.d(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.iNV != null) {
            this.iNV.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.iNV != null) {
            this.iNV.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.iNV != null) {
            this.iNV.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
