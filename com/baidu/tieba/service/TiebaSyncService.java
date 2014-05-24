package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.be;
import com.baidu.tieba.model.bc;
/* loaded from: classes.dex */
public class TiebaSyncService extends Service {
    private static String mStatistics = null;
    private s mSyncTask = null;
    private int mHaveRetry = 0;
    private bc mModel = null;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new r(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(be.class, TiebaSyncService.class);
    }

    public static void setMsgType(String str) {
        mStatistics = str;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.mSyncTask != null) {
            this.mSyncTask.cancel();
        }
        this.mSyncTask = new s(this, null);
        this.mSyncTask.execute(new String[0]);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mSyncTask != null) {
            this.mSyncTask.cancel();
        }
        this.mHaveRetry = 11;
        this.mHandler.removeCallbacks(this.mRunnable);
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        this.mHaveRetry = 0;
        checkUpdata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastNewVersion() {
        if (this.mModel != null) {
            sendBroadcast(new Intent(com.baidu.tieba.data.d.d()));
            BdLog.i(getClass().getName(), "broadcastNewVersion", "sendBroadcast: " + String.format("%s", this.mModel.c().getNewVersion()));
        }
    }
}
