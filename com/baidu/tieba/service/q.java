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
    final /* synthetic */ TiebaActiveService bJe;
    ac bJf;

    private q(TiebaActiveService tiebaActiveService) {
        this.bJe = tiebaActiveService;
        this.bJf = null;
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
            this.bJf = new ac("http://114.113.149.3:8086/partnersService");
            this.bJf.k("apk", aj.wm().getApp().getPackageName());
            this.bJf.k("imei", TbadkApplication.m251getInst().getImei());
            this.bJf.k("model", Build.MODEL);
            this.bJf.k("edition", TbConfig.getVersion());
            this.bJf.k("system", Build.VERSION.SDK);
            this.bJf.mc().na().nd().mIsBaiduServer = false;
            lA = this.bJf.lA();
        } catch (Exception e) {
            com.baidu.tbadk.core.sharedPref.b.lk().putInt("active", 1);
            BdLog.e(e.getMessage());
        }
        if (this.bJf.mf()) {
            return lA;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bJe.mActiveTask = null;
        if (this.bJf != null) {
            this.bJf.dM();
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
        this.bJe.mActiveTask = null;
        if (str == null) {
            TiebaActiveService tiebaActiveService = this.bJe;
            i = tiebaActiveService.mHaveRetry;
            tiebaActiveService.mHaveRetry = i + 1;
            i2 = this.bJe.mHaveRetry;
            if (i2 < 10) {
                handler = this.bJe.mHandler;
                runnable = this.bJe.mRunnable;
                handler.removeCallbacks(runnable);
                handler2 = this.bJe.mHandler;
                runnable2 = this.bJe.mRunnable;
                handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            } else {
                com.baidu.tbadk.core.sharedPref.b.lk().putInt("active", 1);
                this.bJe.stopSelf();
            }
        }
        com.baidu.tbadk.core.sharedPref.b.lk().putInt("active", 2);
        this.bJe.stopSelf();
    }
}
