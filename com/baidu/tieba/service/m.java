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
    final /* synthetic */ TiebaActiveService bOY;
    ad bOZ;

    private m(TiebaActiveService tiebaActiveService) {
        this.bOY = tiebaActiveService;
        this.bOZ = null;
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
        String or;
        try {
            this.bOZ = new ad("http://114.113.149.3:8086/partnersService");
            this.bOZ.o("apk", TbadkCoreApplication.m255getInst().getApp().getPackageName());
            this.bOZ.o("imei", TbadkCoreApplication.m255getInst().getImei());
            this.bOZ.o("model", Build.MODEL);
            this.bOZ.o("edition", TbConfig.getVersion());
            this.bOZ.o("system", Build.VERSION.SDK);
            this.bOZ.oS().pZ().qc().mIsBaiduServer = false;
            or = this.bOZ.or();
        } catch (Exception e) {
            com.baidu.tbadk.core.sharedPref.b.oc().putInt("active", 1);
            BdLog.e(e.getMessage());
        }
        if (this.bOZ.oV()) {
            return or;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bOY.mActiveTask = null;
        if (this.bOZ != null) {
            this.bOZ.dJ();
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
        this.bOY.mActiveTask = null;
        if (str == null) {
            TiebaActiveService tiebaActiveService = this.bOY;
            i = tiebaActiveService.mHaveRetry;
            tiebaActiveService.mHaveRetry = i + 1;
            i2 = this.bOY.mHaveRetry;
            if (i2 < 10) {
                handler = this.bOY.mHandler;
                runnable = this.bOY.mRunnable;
                handler.removeCallbacks(runnable);
                handler2 = this.bOY.mHandler;
                runnable2 = this.bOY.mRunnable;
                handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            } else {
                com.baidu.tbadk.core.sharedPref.b.oc().putInt("active", 1);
                this.bOY.stopSelf();
            }
        }
        com.baidu.tbadk.core.sharedPref.b.oc().putInt("active", 2);
        this.bOY.stopSelf();
    }
}
