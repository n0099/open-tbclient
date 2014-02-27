package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.bj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends BdAsyncTask<String, Integer, String> {
    NetWorkCore a;
    final /* synthetic */ TiebaActiveService b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        String str2 = str;
        super.a((k) str2);
        this.b.a = null;
        if (str2 == null) {
            TiebaActiveService tiebaActiveService = this.b;
            i = tiebaActiveService.b;
            tiebaActiveService.b = i + 1;
            i2 = this.b.b;
            if (i2 < 10) {
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
        com.baidu.adp.lib.util.e.a(getClass().getName(), "onPostExecute", "send active ok");
        com.baidu.tieba.sharedPref.b.a().b("active", 2);
        this.b.stopSelf();
    }

    private k(TiebaActiveService tiebaActiveService) {
        this.b = tiebaActiveService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(TiebaActiveService tiebaActiveService, byte b) {
        this(tiebaActiveService);
    }

    private String d() {
        com.baidu.adp.lib.util.e.a(getClass().getName(), "doBackGround", "send active...");
        try {
            this.a = new NetWorkCore(new bj());
            this.a.b("http://114.113.149.3:8086/partnersService");
            this.a.a(this.b.getApplicationContext());
            this.a.a("apk", TiebaApplication.g().b().getPackageName());
            this.a.a("imei", TiebaApplication.g().k());
            this.a.a("model", Build.MODEL);
            this.a.a("edition", com.baidu.tieba.data.i.u());
            this.a.a("system", Build.VERSION.SDK);
            this.a.e(false);
            String u = this.a.u();
            if (this.a.q()) {
                com.baidu.adp.lib.util.e.a(getClass().getName(), "task", "data=" + u);
                return u;
            }
        } catch (Exception e) {
            com.baidu.tieba.sharedPref.b.a().b("active", 1);
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.b.a = null;
        if (this.a != null) {
            this.a.s();
        }
        super.cancel(true);
    }
}
