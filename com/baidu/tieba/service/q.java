package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tieba.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ TiebaActiveService bIQ;
    ac bIR;

    private q(TiebaActiveService tiebaActiveService) {
        this.bIQ = tiebaActiveService;
        this.bIR = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(TiebaActiveService tiebaActiveService, q qVar) {
        this(tiebaActiveService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public String doInBackground(String... strArr) {
        String lA;
        try {
            this.bIR = new ac("http://114.113.149.3:8086/partnersService");
            this.bIR.k("apk", aj.wk().getApp().getPackageName());
            this.bIR.k("imei", TbadkApplication.m251getInst().getImei());
            this.bIR.k("model", Build.MODEL);
            this.bIR.k("edition", TbConfig.getVersion());
            this.bIR.k("system", Build.VERSION.SDK);
            this.bIR.mc().na().nd().mIsBaiduServer = false;
            lA = this.bIR.lA();
        } catch (Exception e) {
            com.baidu.tbadk.core.sharedPref.b.lk().putInt("active", 1);
            BdLog.e(e.getMessage());
        }
        if (this.bIR.mf()) {
            return lA;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bIQ.mActiveTask = null;
        if (this.bIR != null) {
            this.bIR.dM();
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
        super.onPostExecute((q) str);
        this.bIQ.mActiveTask = null;
        if (str == null) {
            TiebaActiveService tiebaActiveService = this.bIQ;
            i = tiebaActiveService.mHaveRetry;
            tiebaActiveService.mHaveRetry = i + 1;
            i2 = this.bIQ.mHaveRetry;
            if (i2 < 10) {
                handler = this.bIQ.mHandler;
                runnable = this.bIQ.mRunnable;
                handler.removeCallbacks(runnable);
                handler2 = this.bIQ.mHandler;
                runnable2 = this.bIQ.mRunnable;
                handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            } else {
                com.baidu.tbadk.core.sharedPref.b.lk().putInt("active", 1);
                this.bIQ.stopSelf();
            }
        }
        com.baidu.tbadk.core.sharedPref.b.lk().putInt("active", 2);
        this.bIQ.stopSelf();
    }
}
