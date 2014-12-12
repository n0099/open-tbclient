package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
/* loaded from: classes.dex */
public class TiebaSyncService extends BdBaseService {
    private static String mStatistics = null;
    private static long MIN_SYNC_INTERVAL = 300000;
    private p mSyncTask = null;
    private int mHaveRetry = 0;
    private com.baidu.tbadk.coreExtra.c.g mModel = null;
    private long mLastSyncTime = -1;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new n(this);
    private com.baidu.adp.framework.listener.e mOnlineListener = new o(this, 1001);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(SyncServiceConfig.class, TiebaSyncService.class);
    }

    public void checkVersion(String str) {
        String sn;
        if (str != null && this.mModel != null && (sn = this.mModel.sn()) != null && !sn.equalsIgnoreCase(str) && checkAutoSyncInterval()) {
            this.mLastSyncTime = System.currentTimeMillis();
            checkUpdata();
        }
    }

    private boolean checkAutoSyncInterval() {
        if (-1 == this.mLastSyncTime) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mLastSyncTime;
        return currentTimeMillis <= 0 || currentTimeMillis >= MIN_SYNC_INTERVAL;
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
        MessageManager.getInstance().registerListener(this.mOnlineListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.mSyncTask != null) {
            this.mSyncTask.cancel();
        }
        this.mSyncTask = new p(this, null);
        this.mSyncTask.execute(new String[0]);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mSyncTask != null) {
            this.mSyncTask.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.mOnlineListener);
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
            sendBroadcast(new Intent(com.baidu.tbadk.data.b.un()));
        }
    }
}
