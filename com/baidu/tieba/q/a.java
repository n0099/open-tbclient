package com.baidu.tieba.q;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a hsR;
    private InterfaceC0301a hsS = bGe();

    /* renamed from: com.baidu.tieba.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0301a {
        void b(Application application);

        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean bGd() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0301a bGe() {
        CustomResponsedMessage runTask;
        if (!bGd() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0301a.class)) == null) {
            return null;
        }
        return (InterfaceC0301a) runTask.getData();
    }

    public static a bGf() {
        if (hsR == null) {
            synchronized (a.class) {
                if (hsR == null) {
                    hsR = new a();
                }
            }
        }
        return hsR;
    }

    public void b(Application application) {
        if (this.hsS != null) {
            this.hsS.b(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.hsS != null) {
            this.hsS.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.hsS != null) {
            this.hsS.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.hsS != null) {
            this.hsS.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
