package com.baidu.tieba.q;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a gUQ;
    private InterfaceC0222a gUR = byG();

    /* renamed from: com.baidu.tieba.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0222a {
        void b(Application application);

        void behaviorRecordEvent(MotionEvent motionEvent, Activity activity);

        void y(Activity activity);

        void z(Activity activity);
    }

    private boolean byF() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("pref_key_crab_sdk_enable", 1) == 1;
    }

    private a() {
    }

    private InterfaceC0222a byG() {
        CustomResponsedMessage runTask;
        if (!byF() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC0222a.class)) == null) {
            return null;
        }
        return (InterfaceC0222a) runTask.getData();
    }

    public static a byH() {
        if (gUQ == null) {
            synchronized (a.class) {
                if (gUQ == null) {
                    gUQ = new a();
                }
            }
        }
        return gUQ;
    }

    public void b(Application application) {
        if (this.gUR != null) {
            this.gUR.b(application);
        }
    }

    public void y(Activity activity) {
        if (this.gUR != null) {
            this.gUR.y(activity);
        }
    }

    public void z(Activity activity) {
        if (this.gUR != null) {
            this.gUR.z(activity);
        }
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.gUR != null) {
            this.gUR.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
