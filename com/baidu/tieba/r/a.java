package com.baidu.tieba.r;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a iNJ;
    private InterfaceC0374a iNK = chg();

    /* renamed from: com.baidu.tieba.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0374a {
        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void d(Application application);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean chf() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0374a chg() {
        CustomResponsedMessage runTask;
        if (!chf() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0374a.class)) == null) {
            return null;
        }
        return (InterfaceC0374a) runTask.getData();
    }

    public static a chh() {
        if (iNJ == null) {
            synchronized (a.class) {
                if (iNJ == null) {
                    iNJ = new a();
                }
            }
        }
        return iNJ;
    }

    public void d(Application application) {
        if (this.iNK != null) {
            this.iNK.d(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.iNK != null) {
            this.iNK.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.iNK != null) {
            this.iNK.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.iNK != null) {
            this.iNK.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
