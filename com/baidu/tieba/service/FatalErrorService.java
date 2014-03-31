package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class FatalErrorService extends Service {
    private d a = null;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2006003, new c());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.a != null) {
            this.a.cancel();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.a == null) {
            this.a = new d(this, (byte) 0);
            this.a.execute(new String[0]);
        }
    }
}
