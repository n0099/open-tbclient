package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<String, Integer, String> {
    NetWorkCore a;
    final /* synthetic */ TiebaActiveService b;

    private l(TiebaActiveService tiebaActiveService) {
        this.b = tiebaActiveService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(TiebaActiveService tiebaActiveService, k kVar) {
        this(tiebaActiveService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        com.baidu.adp.lib.g.e.a(getClass().getName(), "doBackGround", "send active...");
        try {
            this.a = new NetWorkCore(new bl());
            this.a.b("http://114.113.149.3:8086/partnersService");
            this.a.a(this.b.getApplicationContext());
            this.a.a("apk", TiebaApplication.h().getPackageName());
            this.a.a("imei", TiebaApplication.h().p());
            this.a.a("model", Build.MODEL);
            this.a.a("edition", com.baidu.tieba.data.h.j());
            this.a.a("system", Build.VERSION.SDK);
            this.a.e(false);
            String u = this.a.u();
            if (this.a.q()) {
                com.baidu.adp.lib.g.e.a(getClass().getName(), "task", "data=" + u);
                return u;
            }
        } catch (Exception e) {
            com.baidu.tieba.sharedPref.b.a().b("active", 1);
            com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.a = null;
        if (this.a != null) {
            this.a.s();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        int i;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        super.a((l) str);
        this.b.a = null;
        if (str == null) {
            TiebaActiveService.b(this.b);
            i = this.b.b;
            if (i < 10) {
                handler = this.b.c;
                runnable = this.b.d;
                handler.removeCallbacks(runnable);
                handler2 = this.b.c;
                runnable2 = this.b.d;
                handler2.postDelayed(runnable2, 60000L);
            } else {
                com.baidu.tieba.sharedPref.b.a().b("active", 1);
                this.b.stopSelf();
            }
        }
        com.baidu.adp.lib.g.e.a(getClass().getName(), "onPostExecute", "send active ok");
        com.baidu.tieba.sharedPref.b.a().b("active", 2);
        this.b.stopSelf();
    }
}
