package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.model.SyncModel;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import java.util.Date;
/* loaded from: classes.dex */
public class TiebaSyncService extends Service {
    private SyncAsyncTask mSyncTask = null;
    private int mHaveRetry = 0;
    private SyncModel mModel = null;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.service.TiebaSyncService.1
        @Override // java.lang.Runnable
        public void run() {
            TiebaSyncService.this.checkUpdata();
        }
    };

    static /* synthetic */ int access$408(TiebaSyncService x0) {
        int i = x0.mHaveRetry;
        x0.mHaveRetry = i + 1;
        return i;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent arg0) {
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
        this.mSyncTask = new SyncAsyncTask();
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
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        this.mHaveRetry = 0;
        checkUpdata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class SyncAsyncTask extends AsyncTask<String, Integer, SyncModel> {
        NetWork mNetWork;

        private SyncAsyncTask() {
            this.mNetWork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public SyncModel doInBackground(String... arg0) {
            Exception ex;
            SyncModel data = null;
            try {
                this.mNetWork = new NetWork("http://c.tieba.baidu.com/c/s/sync");
                this.mNetWork.addPostData("_os_version", Build.VERSION.RELEASE);
                StringBuffer buffer = new StringBuffer(15);
                buffer.append(String.valueOf(UtilHelper.getEquipmentWidth(TiebaApplication.app)));
                buffer.append(",");
                buffer.append(String.valueOf(UtilHelper.getEquipmentHeight(TiebaApplication.app)));
                this.mNetWork.addPostData("_phone_screen", buffer.toString());
                if (TiebaApplication.app.getMsgFrequency() > 0) {
                    this.mNetWork.addPostData("_msg_status", "0");
                } else {
                    this.mNetWork.addPostData("_msg_status", NetWorkCore.NET_TYPE_NET);
                }
                String ret = this.mNetWork.postNetData();
                if (!this.mNetWork.isRequestSuccess()) {
                    return null;
                }
                SyncModel data2 = new SyncModel();
                try {
                    data2.parserJson(ret);
                    String id = TiebaApplication.getClientId();
                    if (id == null && data2.getClient().getClient_id() != null && data2.getClient().getClient_id().length() > 0) {
                        TiebaApplication.saveClientId(TiebaSyncService.this, data2.getClient().getClient_id());
                        TiebaApplication.setClientId(data2.getClient().getClient_id());
                    }
                    return data2;
                } catch (Exception e) {
                    ex = e;
                    data = data2;
                    TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                    return data;
                }
            } catch (Exception e2) {
                ex = e2;
            }
        }

        public void cancel() {
            TiebaSyncService.this.mSyncTask = null;
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(SyncModel result) {
            super.onPostExecute((SyncAsyncTask) result);
            TiebaSyncService.this.mSyncTask = null;
            if (result != null) {
                TiebaSyncService.this.mModel = result;
                if (TiebaSyncService.this.mModel.getVersion().getHas_new_ver() == 1 && Config.COULD_UPDATE) {
                    if (TiebaSyncService.this.mModel.getVersion().getForce_update() == 1) {
                        UpdateDialog.startActivity(TiebaApplication.app, TiebaSyncService.this.mModel.getVersion());
                    } else {
                        Long old_time = Long.valueOf(TiebaApplication.app.getUpdateNotifyTime());
                        Long new_time = Long.valueOf(new Date().getTime());
                        if (new_time.longValue() - old_time.longValue() > 86400000) {
                            TiebaApplication.app.setUpdateNotifyTime(new_time.longValue());
                            UpdateDialog.startActivity(TiebaApplication.app, TiebaSyncService.this.mModel.getVersion());
                        }
                    }
                }
                TiebaSyncService.this.stopSelf();
                return;
            }
            TiebaSyncService.access$408(TiebaSyncService.this);
            if (TiebaSyncService.this.mHaveRetry < 10) {
                TiebaSyncService.this.mHandler.removeCallbacks(TiebaSyncService.this.mRunnable);
                TiebaSyncService.this.mHandler.postDelayed(TiebaSyncService.this.mRunnable, 60000L);
                return;
            }
            TiebaSyncService.this.stopSelf();
        }
    }
}
