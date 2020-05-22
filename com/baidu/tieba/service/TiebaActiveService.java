package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
/* loaded from: classes.dex */
public class TiebaActiveService extends BdBaseService {
    private static final int ACTIVE_FAIL = 1;
    private static final int ACTIVE_SUCC = 2;
    private a mActiveTask = null;
    private int mHaveRetry = 0;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.service.TiebaActiveService.1
        @Override // java.lang.Runnable
        public void run() {
            TiebaActiveService.this.sendActive();
        }
    };

    static /* synthetic */ int access$308(TiebaActiveService tiebaActiveService) {
        int i = tiebaActiveService.mHaveRetry;
        tiebaActiveService.mHaveRetry = i + 1;
        return i;
    }

    private String getChannelByShare() {
        return b.aTX().getString(SharedPrefConfig.CHANNEL_ID, null);
    }

    private void saveChannelToShare(String str) {
        if (str != null && str.length() > 0) {
            b.aTX().putString(SharedPrefConfig.CHANNEL_ID, str);
        }
    }

    private String getChannelyFile() {
        String str = null;
        try {
            File GetFile = m.GetFile(TbConfig.CHANNEL_FILE);
            if (GetFile != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(GetFile));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "TiebaActiveService.getChannelyFile");
        }
        return str;
    }

    private void saveChannelToFile(String str) {
        if (str != null && str.length() > 0) {
            try {
                File CreateFile = m.CreateFile(TbConfig.CHANNEL_FILE);
                if (CreateFile != null) {
                    FileWriter fileWriter = new FileWriter(CreateFile);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "TiebaActiveService.saveChannelToFile");
            }
        }
    }

    private boolean isActived() {
        try {
            String channelByShare = getChannelByShare();
            if (channelByShare == null) {
                String channelyFile = getChannelyFile();
                if (channelyFile != null && channelyFile.length() > 0) {
                    saveChannelToShare(channelyFile);
                } else {
                    if ("aishide" != 0 && "aishide".length() > 0) {
                        saveChannelToShare("aishide");
                        saveChannelToFile("aishide");
                    }
                    return false;
                }
            } else {
                saveChannelToFile(channelByShare);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return true;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (isActived() && b.aTX().getInt(SharedPrefConfig.ACTIVE_STATE, 2) != 1) {
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
        this.mActiveTask = new a();
        this.mActiveTask.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        x kTC;

        private a() {
            this.kTC = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String postNetData;
            try {
                this.kTC = new x(Config.CHANNEL_ADDRESS);
                this.kTC.addPostData("apk", TbadkCoreApplication.getInst().getApp().getPackageName());
                this.kTC.addPostData("imei", TbadkCoreApplication.getInst().getImei());
                this.kTC.addPostData("model", Build.MODEL);
                this.kTC.addPostData("edition", TbConfig.getVersion());
                this.kTC.addPostData("system", Build.VERSION.SDK);
                this.kTC.aUA().aVa().aVe().mIsBaiduServer = false;
                postNetData = this.kTC.postNetData();
            } catch (Exception e) {
                b.aTX().putInt(SharedPrefConfig.ACTIVE_STATE, 1);
                BdLog.e(e.getMessage());
            }
            if (this.kTC.isNetSuccess()) {
                return postNetData;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            TiebaActiveService.this.mActiveTask = null;
            if (this.kTC != null) {
                this.kTC.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            TiebaActiveService.this.mActiveTask = null;
            if (str == null) {
                TiebaActiveService.access$308(TiebaActiveService.this);
                if (TiebaActiveService.this.mHaveRetry < 10) {
                    TiebaActiveService.this.mHandler.removeCallbacks(TiebaActiveService.this.mRunnable);
                    TiebaActiveService.this.mHandler.postDelayed(TiebaActiveService.this.mRunnable, 60000L);
                } else {
                    b.aTX().putInt(SharedPrefConfig.ACTIVE_STATE, 1);
                    TiebaActiveService.this.stopSelf();
                }
            }
            b.aTX().putInt(SharedPrefConfig.ACTIVE_STATE, 2);
            TiebaActiveService.this.stopSelf();
        }
    }
}
