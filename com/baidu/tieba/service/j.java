package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ TiebaActiveService bZq;
    aa bZr;

    private j(TiebaActiveService tiebaActiveService) {
        this.bZq = tiebaActiveService;
        this.bZr = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(TiebaActiveService tiebaActiveService, j jVar) {
        this(tiebaActiveService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        String rO;
        try {
            this.bZr = new aa("http://114.113.149.3:8086/partnersService");
            this.bZr.o("apk", TbadkCoreApplication.m411getInst().getApp().getPackageName());
            this.bZr.o("imei", TbadkCoreApplication.m411getInst().getImei());
            this.bZr.o("model", Build.MODEL);
            this.bZr.o("edition", TbConfig.getVersion());
            this.bZr.o("system", Build.VERSION.SDK);
            this.bZr.sp().tp().ts().mIsBaiduServer = false;
            rO = this.bZr.rO();
        } catch (Exception e) {
            com.baidu.tbadk.core.sharedPref.b.rB().putInt("active", 1);
            BdLog.e(e.getMessage());
        }
        if (this.bZr.ss()) {
            return rO;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bZq.mActiveTask = null;
        if (this.bZr != null) {
            this.bZr.hh();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        super.onPostExecute((j) str);
        this.bZq.mActiveTask = null;
        if (str == null) {
            TiebaActiveService tiebaActiveService = this.bZq;
            i = tiebaActiveService.mHaveRetry;
            tiebaActiveService.mHaveRetry = i + 1;
            i2 = this.bZq.mHaveRetry;
            if (i2 < 10) {
                handler = this.bZq.mHandler;
                runnable = this.bZq.mRunnable;
                handler.removeCallbacks(runnable);
                handler2 = this.bZq.mHandler;
                runnable2 = this.bZq.mRunnable;
                handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            } else {
                com.baidu.tbadk.core.sharedPref.b.rB().putInt("active", 1);
                this.bZq.stopSelf();
            }
        }
        com.baidu.tbadk.core.sharedPref.b.rB().putInt("active", 2);
        this.bZq.stopSelf();
    }
}
