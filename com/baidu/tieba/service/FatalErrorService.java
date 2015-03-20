package com.baidu.tieba.service;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
/* loaded from: classes.dex */
public class FatalErrorService extends BdBaseService {
    private static final String ERROR_TYPE_KEY = "errortype";
    private static final String ERROR_TYPE_NATIVE_C = "4";
    private static final String ERROR_TYPE_UNKNOW = "0";
    private static final int NATIVE_CRASH_DUMP_MIN_SIZE = 1024;
    private e mTask = null;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.mTask != null) {
            this.mTask.cancel();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.mTask == null) {
            this.mTask = new e(this, intent);
            this.mTask.execute(new String[0]);
        }
    }
}
