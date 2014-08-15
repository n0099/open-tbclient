package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tieba.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<String, Integer, String> {
    ae a;
    final /* synthetic */ TiebaActiveService b;

    private p(TiebaActiveService tiebaActiveService) {
        this.b = tiebaActiveService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(TiebaActiveService tiebaActiveService, p pVar) {
        this(tiebaActiveService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String h;
        try {
            this.a = new ae("http://114.113.149.3:8086/partnersService");
            this.a.a("apk", ai.c().d().getPackageName());
            this.a.a("imei", TbadkApplication.m252getInst().getImei());
            this.a.a("model", Build.MODEL);
            this.a.a("edition", TbConfig.getVersion());
            this.a.a("system", Build.VERSION.SDK);
            this.a.a().a().a().f = false;
            h = this.a.h();
        } catch (Exception e) {
            com.baidu.tbadk.core.sharedPref.b.a().b("active", 1);
            BdLog.e(e.getMessage());
        }
        if (this.a.b()) {
            return h;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.mActiveTask = null;
        if (this.a != null) {
            this.a.f();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        super.onPostExecute(str);
        this.b.mActiveTask = null;
        if (str == null) {
            TiebaActiveService tiebaActiveService = this.b;
            i = tiebaActiveService.mHaveRetry;
            tiebaActiveService.mHaveRetry = i + 1;
            i2 = this.b.mHaveRetry;
            if (i2 < 10) {
                handler = this.b.mHandler;
                runnable = this.b.mRunnable;
                handler.removeCallbacks(runnable);
                handler2 = this.b.mHandler;
                runnable2 = this.b.mRunnable;
                handler2.postDelayed(runnable2, TbConfig.USE_TIME_INTERVAL);
            } else {
                com.baidu.tbadk.core.sharedPref.b.a().b("active", 1);
                this.b.stopSelf();
            }
        }
        com.baidu.tbadk.core.sharedPref.b.a().b("active", 2);
        this.b.stopSelf();
    }
}
