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
    final /* synthetic */ TiebaActiveService bZb;
    aa bZc;

    private j(TiebaActiveService tiebaActiveService) {
        this.bZb = tiebaActiveService;
        this.bZc = null;
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
            this.bZc = new aa("http://114.113.149.3:8086/partnersService");
            this.bZc.o("apk", TbadkCoreApplication.m411getInst().getApp().getPackageName());
            this.bZc.o("imei", TbadkCoreApplication.m411getInst().getImei());
            this.bZc.o("model", Build.MODEL);
            this.bZc.o("edition", TbConfig.getVersion());
            this.bZc.o("system", Build.VERSION.SDK);
            this.bZc.sp().tp().ts().mIsBaiduServer = false;
            rO = this.bZc.rO();
        } catch (Exception e) {
            com.baidu.tbadk.core.sharedPref.b.rB().putInt("active", 1);
            BdLog.e(e.getMessage());
        }
        if (this.bZc.ss()) {
            return rO;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bZb.mActiveTask = null;
        if (this.bZc != null) {
            this.bZc.hh();
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
        this.bZb.mActiveTask = null;
        if (str == null) {
            TiebaActiveService tiebaActiveService = this.bZb;
            i = tiebaActiveService.mHaveRetry;
            tiebaActiveService.mHaveRetry = i + 1;
            i2 = this.bZb.mHaveRetry;
            if (i2 < 10) {
                handler = this.bZb.mHandler;
                runnable = this.bZb.mRunnable;
                handler.removeCallbacks(runnable);
                handler2 = this.bZb.mHandler;
                runnable2 = this.bZb.mRunnable;
                handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            } else {
                com.baidu.tbadk.core.sharedPref.b.rB().putInt("active", 1);
                this.bZb.stopSelf();
            }
        }
        com.baidu.tbadk.core.sharedPref.b.rB().putInt("active", 2);
        this.bZb.stopSelf();
    }
}
