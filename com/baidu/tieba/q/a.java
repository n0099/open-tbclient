package com.baidu.tieba.q;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a gUO;
    private InterfaceC0222a gUP = byE();

    /* renamed from: com.baidu.tieba.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0222a {
        void b(Application application);

        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void y(Activity activity);

        void z(Activity activity);
    }

    private boolean byD() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0222a byE() {
        CustomResponsedMessage runTask;
        if (!byD() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0222a.class)) == null) {
            return null;
        }
        return (InterfaceC0222a) runTask.getData();
    }

    public static a byF() {
        if (gUO == null) {
            synchronized (a.class) {
                if (gUO == null) {
                    gUO = new a();
                }
            }
        }
        return gUO;
    }

    public void b(Application application) {
        if (this.gUP != null) {
            this.gUP.b(application);
        }
    }

    public void y(Activity activity) {
        if (this.gUP != null) {
            this.gUP.y(activity);
        }
    }

    public void z(Activity activity) {
        if (this.gUP != null) {
            this.gUP.z(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.gUP != null) {
            this.gUP.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
