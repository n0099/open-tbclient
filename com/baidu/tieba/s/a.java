package com.baidu.tieba.s;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a mInstance;
    private InterfaceC0593a mICrabSdk = getCrabSdk();

    /* renamed from: com.baidu.tieba.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0593a {
        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void initSdk(Application application);

        void onPause(Activity activity);

        void onResume(Activity activity);

        void uploadException(Exception exc);
    }

    private boolean isCrabSdkSwitchOn() {
        return com.baidu.tbadk.core.sharedPref.b.aDr().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0593a getCrabSdk() {
        CustomResponsedMessage runTask;
        if (!isCrabSdkSwitchOn() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0593a.class)) == null) {
            return null;
        }
        return (InterfaceC0593a) runTask.getData();
    }

    public static a getInstance() {
        if (mInstance == null) {
            synchronized (a.class) {
                if (mInstance == null) {
                    mInstance = new a();
                }
            }
        }
        return mInstance;
    }

    public void initSdk(Application application) {
        if (this.mICrabSdk != null) {
            this.mICrabSdk.initSdk(application);
        }
    }

    public void onPause(Activity activity) {
        if (this.mICrabSdk != null) {
            this.mICrabSdk.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        if (this.mICrabSdk != null) {
            this.mICrabSdk.onResume(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.mICrabSdk != null) {
            this.mICrabSdk.behaviorRecordEvent(motionEvent, activity);
        }
    }

    public void uploadException(Exception exc) {
        if (this.mICrabSdk != null) {
            this.mICrabSdk.uploadException(exc);
        }
    }
}
