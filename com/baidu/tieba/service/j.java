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
    final /* synthetic */ TiebaActiveService cdD;
    aa cdE;

    private j(TiebaActiveService tiebaActiveService) {
        this.cdD = tiebaActiveService;
        this.cdE = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(TiebaActiveService tiebaActiveService, j jVar) {
        this(tiebaActiveService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        String sw;
        try {
            this.cdE = new aa("http://114.113.149.3:8086/partnersService");
            this.cdE.o("apk", TbadkCoreApplication.m411getInst().getApp().getPackageName());
            this.cdE.o("imei", TbadkCoreApplication.m411getInst().getImei());
            this.cdE.o("model", Build.MODEL);
            this.cdE.o("edition", TbConfig.getVersion());
            this.cdE.o("system", Build.VERSION.SDK);
            this.cdE.sX().tS().tV().mIsBaiduServer = false;
            sw = this.cdE.sw();
        } catch (Exception e) {
            com.baidu.tbadk.core.sharedPref.b.sl().putInt("active", 1);
            BdLog.e(e.getMessage());
        }
        if (this.cdE.ta()) {
            return sw;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.cdD.mActiveTask = null;
        if (this.cdE != null) {
            this.cdE.gS();
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
        this.cdD.mActiveTask = null;
        if (str == null) {
            TiebaActiveService tiebaActiveService = this.cdD;
            i = tiebaActiveService.mHaveRetry;
            tiebaActiveService.mHaveRetry = i + 1;
            i2 = this.cdD.mHaveRetry;
            if (i2 < 10) {
                handler = this.cdD.mHandler;
                runnable = this.cdD.mRunnable;
                handler.removeCallbacks(runnable);
                handler2 = this.cdD.mHandler;
                runnable2 = this.cdD.mRunnable;
                handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            } else {
                com.baidu.tbadk.core.sharedPref.b.sl().putInt("active", 1);
                this.cdD.stopSelf();
            }
        }
        com.baidu.tbadk.core.sharedPref.b.sl().putInt("active", 2);
        this.cdD.stopSelf();
    }
}
