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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.w;
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
    private Runnable mRunnable = new f(this);

    private String getChannelByShare() {
        return com.baidu.tbadk.core.sharedPref.b.tr().getString("channel_id", null);
    }

    private void saveChannelToShare(String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tbadk.core.sharedPref.b.tr().putString("channel_id", str);
        }
    }

    private String getChannelyFile() {
        String str = null;
        try {
            File cJ = n.cJ(TbConfig.CHANNEL_FILE);
            if (cJ != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(cJ));
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
                File cN = n.cN(TbConfig.CHANNEL_FILE);
                if (cN != null) {
                    FileWriter fileWriter = new FileWriter(cN);
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
        if (isActived() && com.baidu.tbadk.core.sharedPref.b.tr().getInt("active", 2) != 1) {
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
        this.mActiveTask = new a(this, null);
        this.mActiveTask.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        w cLb;

        private a() {
            this.cLb = null;
        }

        /* synthetic */ a(TiebaActiveService tiebaActiveService, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String tD;
            try {
                this.cLb = new w("http://114.113.149.3:8086/partnersService");
                this.cLb.o("apk", TbadkCoreApplication.m411getInst().getApp().getPackageName());
                this.cLb.o("imei", TbadkCoreApplication.m411getInst().getImei());
                this.cLb.o("model", Build.MODEL);
                this.cLb.o("edition", TbConfig.getVersion());
                this.cLb.o("system", Build.VERSION.SDK);
                this.cLb.ue().uV().uY().mIsBaiduServer = false;
                tD = this.cLb.tD();
            } catch (Exception e) {
                com.baidu.tbadk.core.sharedPref.b.tr().putInt("active", 1);
                BdLog.e(e.getMessage());
            }
            if (this.cLb.uh()) {
                return tD;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            TiebaActiveService.this.mActiveTask = null;
            if (this.cLb != null) {
                this.cLb.gJ();
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
                TiebaActiveService.this.mHaveRetry++;
                if (TiebaActiveService.this.mHaveRetry < 10) {
                    TiebaActiveService.this.mHandler.removeCallbacks(TiebaActiveService.this.mRunnable);
                    TiebaActiveService.this.mHandler.postDelayed(TiebaActiveService.this.mRunnable, TbConfig.USE_TIME_INTERVAL);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.tr().putInt("active", 1);
                    TiebaActiveService.this.stopSelf();
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tr().putInt("active", 2);
            TiebaActiveService.this.stopSelf();
        }
    }
}
