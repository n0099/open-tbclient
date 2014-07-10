package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.br;
import com.baidu.tieba.model.bd;
/* loaded from: classes.dex */
public class TiebaSyncService extends Service {
    private static String mStatistics = null;
    private r mSyncTask = null;
    private int mHaveRetry = 0;
    private bd mModel = null;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new q(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(br.class, TiebaSyncService.class);
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
        this.mSyncTask = new r(this, null);
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
            sendBroadcast(new Intent(com.baidu.tieba.data.e.d()));
        }
    }
}
