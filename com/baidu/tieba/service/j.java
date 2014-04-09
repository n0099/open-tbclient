package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends BdAsyncTask<String, Integer, String> {
    ak a;
    final /* synthetic */ TiebaActiveService b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ String a(String... strArr) {
        return a();
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
        super.a((j) str2);
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
                com.baidu.tbadk.core.sharedPref.b.a().b("active", 1);
                this.b.stopSelf();
            }
        }
        com.baidu.adp.lib.util.f.a(getClass().getName(), "onPostExecute", "send active ok");
        com.baidu.tbadk.core.sharedPref.b.a().b("active", 2);
        this.b.stopSelf();
    }

    private j(TiebaActiveService tiebaActiveService) {
        this.b = tiebaActiveService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(TiebaActiveService tiebaActiveService, byte b) {
        this(tiebaActiveService);
    }

    private String a() {
        com.baidu.adp.lib.util.f.a(getClass().getName(), "doBackGround", "send active...");
        try {
            this.a = new ak("http://114.113.149.3:8086/partnersService");
            ak akVar = this.a;
            com.baidu.tieba.p.c();
            akVar.a("apk", com.baidu.tieba.p.d().getPackageName());
            this.a.a("imei", TbadkApplication.j().C());
            this.a.a("model", Build.MODEL);
            this.a.a("edition", com.baidu.tbadk.core.data.n.c());
            this.a.a("system", Build.VERSION.SDK);
            this.a.a().a().a().f = false;
            String i = this.a.i();
            if (this.a.c()) {
                com.baidu.adp.lib.util.f.a(getClass().getName(), "task", "data=" + i);
                return i;
            }
        } catch (Exception e) {
            com.baidu.tbadk.core.sharedPref.b.a().b("active", 1);
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.b.a = null;
        if (this.a != null) {
            this.a.g();
        }
        super.cancel(true);
    }
}
