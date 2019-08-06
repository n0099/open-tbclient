package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
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
        return b.ahQ().getString("channel_id", null);
    }

    private void saveChannelToShare(String str) {
        if (str != null && str.length() > 0) {
            b.ahQ().putString("channel_id", str);
        }
    }

    private String getChannelyFile() {
        String str = null;
        try {
            File nk = m.nk(TbConfig.CHANNEL_FILE);
            if (nk != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(nk));
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
                File nq = m.nq(TbConfig.CHANNEL_FILE);
                if (nq != null) {
                    FileWriter fileWriter = new FileWriter(nq);
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
        if (isActived() && b.ahQ().getInt("active", 2) != 1) {
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
        x iQl;

        private a() {
            this.iQl = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String aii;
            try {
                this.iQl = new x("http://114.113.149.3:8086/partnersService");
                this.iQl.o("apk", TbadkCoreApplication.getInst().getApp().getPackageName());
                this.iQl.o("imei", TbadkCoreApplication.getInst().getImei());
                this.iQl.o("model", Build.MODEL);
                this.iQl.o("edition", TbConfig.getVersion());
                this.iQl.o("system", Build.VERSION.SDK);
                this.iQl.aiG().ajG().ajJ().mIsBaiduServer = false;
                aii = this.iQl.aii();
            } catch (Exception e) {
                b.ahQ().putInt("active", 1);
                BdLog.e(e.getMessage());
            }
            if (this.iQl.aiJ()) {
                return aii;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            TiebaActiveService.this.mActiveTask = null;
            if (this.iQl != null) {
                this.iQl.ik();
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
                    b.ahQ().putInt("active", 1);
                    TiebaActiveService.this.stopSelf();
                }
            }
            b.ahQ().putInt("active", 2);
            TiebaActiveService.this.stopSelf();
        }
    }
}
