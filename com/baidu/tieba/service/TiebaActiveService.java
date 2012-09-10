package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.TiebaLog;
/* loaded from: classes.dex */
public class TiebaActiveService extends Service {
    private static final int ACTIVE_FAIL = 1;
    private static final int ACTIVE_NO = 0;
    private static final int ACTIVE_SUCC = 2;
    private ActiveTask mActiveTask = null;
    private int mHaveRetry = 0;
    private boolean mNeedActive = false;
    private int activeState = 0;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.service.TiebaActiveService.1
        @Override // java.lang.Runnable
        public void run() {
            TiebaActiveService.this.sendActive();
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        this.mNeedActive = intent.getBooleanExtra(Config.SYNC_ACTIVE, false);
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        this.activeState = preference.getInt(Config.ACTIVE_STATE, 0);
        this.mHaveRetry = 0;
        TiebaLog.i(getClass().getName(), "onStart", "sync_active=" + String.valueOf(this.mNeedActive) + " activeState=" + String.valueOf(this.activeState));
        if (this.activeState == 1 || (this.activeState == 0 && this.mNeedActive)) {
            sendActive();
        } else {
            stopSelf();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mActiveTask != null) {
            this.mActiveTask.cancel();
        }
        this.mHaveRetry = 11;
        this.mHandler.removeCallbacks(this.mRunnable);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendActive() {
        if (this.mActiveTask != null) {
            this.mActiveTask.cancel();
        }
        this.mActiveTask = new ActiveTask(this, null);
        this.mActiveTask.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ActiveTask extends AsyncTask<String, Integer, String> {
        NetWorkCore mNetWorkCore;

        private ActiveTask() {
            this.mNetWorkCore = null;
        }

        /* synthetic */ ActiveTask(TiebaActiveService tiebaActiveService, ActiveTask activeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... params) {
            TiebaLog.i(getClass().getName(), "doBackGround", "send active...");
            try {
                this.mNetWorkCore = new NetWorkCore(Config.CHANNEL_ADDRESS);
                this.mNetWorkCore.setUrl(Config.CHANNEL_ADDRESS);
                this.mNetWorkCore.setContext(TiebaActiveService.this.getApplicationContext());
                this.mNetWorkCore.addPostData("apk", TiebaApplication.app.getPackageName());
                this.mNetWorkCore.addPostData("imei", TiebaApplication.app.getImei());
                this.mNetWorkCore.addPostData("model", Build.MODEL);
                this.mNetWorkCore.addPostData("edition", Config.VERSION);
                this.mNetWorkCore.addPostData("system", Build.VERSION.SDK);
                this.mNetWorkCore.setIsBaiduServer(false);
                String data = this.mNetWorkCore.postNetData();
                if (this.mNetWorkCore.isRequestSuccess()) {
                    TiebaLog.i(getClass().getName(), "task", "data=" + data);
                    return data;
                }
            } catch (Exception ex) {
                SharedPreferences preference = TiebaActiveService.this.getSharedPreferences(Config.SETTINGFILE, 0);
                SharedPreferences.Editor editor = preference.edit();
                editor.putInt(Config.ACTIVE_STATE, 1);
                editor.commit();
                TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
            }
            return null;
        }

        public void cancel() {
            TiebaActiveService.this.mActiveTask = null;
            if (this.mNetWorkCore != null) {
                this.mNetWorkCore.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((ActiveTask) result);
            TiebaActiveService.this.mActiveTask = null;
            SharedPreferences preference = TiebaActiveService.this.getSharedPreferences(Config.SETTINGFILE, 0);
            SharedPreferences.Editor editor = preference.edit();
            editor.putInt(Config.ACTIVE_STATE, 1);
            if (result == null) {
                TiebaActiveService.this.mHaveRetry++;
                if (TiebaActiveService.this.mHaveRetry < 10) {
                    TiebaActiveService.this.mHandler.removeCallbacks(TiebaActiveService.this.mRunnable);
                    TiebaActiveService.this.mHandler.postDelayed(TiebaActiveService.this.mRunnable, 60000L);
                } else {
                    editor.commit();
                    TiebaActiveService.this.stopSelf();
                }
            }
            TiebaLog.i(getClass().getName(), "onPostExecute", "send active ok");
            editor.putInt(Config.ACTIVE_STATE, 2);
            editor.commit();
            TiebaActiveService.this.stopSelf();
        }
    }
}
