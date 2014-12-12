package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ TiebaActiveService bNp;
    ad bNq;

    private m(TiebaActiveService tiebaActiveService) {
        this.bNp = tiebaActiveService;
        this.bNq = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(TiebaActiveService tiebaActiveService, m mVar) {
        this(tiebaActiveService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        String ov;
        try {
            this.bNq = new ad("http://114.113.149.3:8086/partnersService");
            this.bNq.o("apk", TbadkCoreApplication.m255getInst().getApp().getPackageName());
            this.bNq.o("imei", TbadkCoreApplication.m255getInst().getImei());
            this.bNq.o("model", Build.MODEL);
            this.bNq.o("edition", TbConfig.getVersion());
            this.bNq.o("system", Build.VERSION.SDK);
            this.bNq.oW().pV().pY().mIsBaiduServer = false;
            ov = this.bNq.ov();
        } catch (Exception e) {
            com.baidu.tbadk.core.sharedPref.b.og().putInt("active", 1);
            BdLog.e(e.getMessage());
        }
        if (this.bNq.oZ()) {
            return ov;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bNp.mActiveTask = null;
        if (this.bNq != null) {
            this.bNq.dL();
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
        super.onPostExecute((m) str);
        this.bNp.mActiveTask = null;
        if (str == null) {
            TiebaActiveService tiebaActiveService = this.bNp;
            i = tiebaActiveService.mHaveRetry;
            tiebaActiveService.mHaveRetry = i + 1;
            i2 = this.bNp.mHaveRetry;
            if (i2 < 10) {
                handler = this.bNp.mHandler;
                runnable = this.bNp.mRunnable;
                handler.removeCallbacks(runnable);
                handler2 = this.bNp.mHandler;
                runnable2 = this.bNp.mRunnable;
                handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            } else {
                com.baidu.tbadk.core.sharedPref.b.og().putInt("active", 1);
                this.bNp.stopSelf();
            }
        }
        com.baidu.tbadk.core.sharedPref.b.og().putInt("active", 2);
        this.bNp.stopSelf();
    }
}
