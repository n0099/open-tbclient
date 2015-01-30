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
    final /* synthetic */ TiebaActiveService bOZ;
    ad bPa;

    private m(TiebaActiveService tiebaActiveService) {
        this.bOZ = tiebaActiveService;
        this.bPa = null;
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
        String oy;
        try {
            this.bPa = new ad("http://114.113.149.3:8086/partnersService");
            this.bPa.o("apk", TbadkCoreApplication.m255getInst().getApp().getPackageName());
            this.bPa.o("imei", TbadkCoreApplication.m255getInst().getImei());
            this.bPa.o("model", Build.MODEL);
            this.bPa.o("edition", TbConfig.getVersion());
            this.bPa.o("system", Build.VERSION.SDK);
            this.bPa.oZ().qg().qj().mIsBaiduServer = false;
            oy = this.bPa.oy();
        } catch (Exception e) {
            com.baidu.tbadk.core.sharedPref.b.oj().putInt("active", 1);
            BdLog.e(e.getMessage());
        }
        if (this.bPa.pc()) {
            return oy;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bOZ.mActiveTask = null;
        if (this.bPa != null) {
            this.bPa.dJ();
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
        this.bOZ.mActiveTask = null;
        if (str == null) {
            TiebaActiveService tiebaActiveService = this.bOZ;
            i = tiebaActiveService.mHaveRetry;
            tiebaActiveService.mHaveRetry = i + 1;
            i2 = this.bOZ.mHaveRetry;
            if (i2 < 10) {
                handler = this.bOZ.mHandler;
                runnable = this.bOZ.mRunnable;
                handler.removeCallbacks(runnable);
                handler2 = this.bOZ.mHandler;
                runnable2 = this.bOZ.mRunnable;
                handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            } else {
                com.baidu.tbadk.core.sharedPref.b.oj().putInt("active", 1);
                this.bOZ.stopSelf();
            }
        }
        com.baidu.tbadk.core.sharedPref.b.oj().putInt("active", 2);
        this.bOZ.stopSelf();
    }
}
