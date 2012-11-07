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
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.TiebaLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
/* loaded from: classes.dex */
public class TiebaActiveService extends Service {
    private static final int ACTIVE_FAIL = 1;
    private static final int ACTIVE_SUCC = 2;
    private static final String CHANNEL_ID = "channel_id";
    private ActiveTask mActiveTask = null;
    private int mHaveRetry = 0;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.service.TiebaActiveService.1
        @Override // java.lang.Runnable
        public void run() {
            TiebaActiveService.this.sendActive();
        }
    };

    private String getChannelByShare() {
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        return preference.getString(CHANNEL_ID, null);
    }

    private void saveChannelToShare(String channel) {
        if (channel != null && channel.length() > 0) {
            SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
            SharedPreferences.Editor editor = preference.edit();
            editor.putString(CHANNEL_ID, channel);
            editor.commit();
        }
    }

    private String getChannelyFile() {
        String from = null;
        try {
            File file = FileHelper.GetFile(Config.CHANNEL_FILE);
            if (file != null) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                from = reader.readLine();
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "getFromByFile", ex.getMessage());
        }
        return from;
    }

    private void saveChannelToFile(String channel) {
        if (channel != null && channel.length() > 0) {
            try {
                File file = FileHelper.CreateFile(Config.CHANNEL_FILE);
                if (file != null) {
                    FileWriter write = new FileWriter(file);
                    write.append((CharSequence) channel);
                    write.flush();
                    write.close();
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "saveFromToFile", ex.getMessage());
            }
        }
    }

    private boolean isActived() {
        try {
            String channel = getChannelByShare();
            if (channel == null) {
                String channel2 = getChannelyFile();
                if (channel2 != null && channel2.length() > 0) {
                    saveChannelToShare(channel2);
                } else {
                    if ("aishide" != 0 && "aishide".length() > 0) {
                        saveChannelToShare("aishide");
                        saveChannelToFile("aishide");
                    }
                    return false;
                }
            } else {
                saveChannelToFile(channel);
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "getActiveState", ex.getMessage());
        }
        TiebaLog.i(getClass().getName(), "getActiveState", "channel = ");
        return true;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (isActived() && getSharedPreferences(Config.SETTINGFILE, 0).getInt(Config.ACTIVE_STATE, 2) != 1) {
            stopSelf();
        } else {
            sendActive();
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
                if (this.mNetWorkCore.isNetSuccess()) {
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
