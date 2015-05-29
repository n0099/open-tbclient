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
    final /* synthetic */ TiebaActiveService cdC;
    aa cdD;

    private j(TiebaActiveService tiebaActiveService) {
        this.cdC = tiebaActiveService;
        this.cdD = null;
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
            this.cdD = new aa("http://114.113.149.3:8086/partnersService");
            this.cdD.o("apk", TbadkCoreApplication.m411getInst().getApp().getPackageName());
            this.cdD.o("imei", TbadkCoreApplication.m411getInst().getImei());
            this.cdD.o("model", Build.MODEL);
            this.cdD.o("edition", TbConfig.getVersion());
            this.cdD.o("system", Build.VERSION.SDK);
            this.cdD.sX().tS().tV().mIsBaiduServer = false;
            sw = this.cdD.sw();
        } catch (Exception e) {
            com.baidu.tbadk.core.sharedPref.b.sl().putInt("active", 1);
            BdLog.e(e.getMessage());
        }
        if (this.cdD.ta()) {
            return sw;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.cdC.mActiveTask = null;
        if (this.cdD != null) {
            this.cdD.gS();
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
        this.cdC.mActiveTask = null;
        if (str == null) {
            TiebaActiveService tiebaActiveService = this.cdC;
            i = tiebaActiveService.mHaveRetry;
            tiebaActiveService.mHaveRetry = i + 1;
            i2 = this.cdC.mHaveRetry;
            if (i2 < 10) {
                handler = this.cdC.mHandler;
                runnable = this.cdC.mRunnable;
                handler.removeCallbacks(runnable);
                handler2 = this.cdC.mHandler;
                runnable2 = this.cdC.mRunnable;
                handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            } else {
                com.baidu.tbadk.core.sharedPref.b.sl().putInt("active", 1);
                this.cdC.stopSelf();
            }
        }
        com.baidu.tbadk.core.sharedPref.b.sl().putInt("active", 2);
        this.cdC.stopSelf();
    }
}
