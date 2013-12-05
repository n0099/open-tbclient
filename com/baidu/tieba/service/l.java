package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.aw;
import com.baidu.tieba.util.bd;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    NetWorkCore f2450a;
    final /* synthetic */ TiebaActiveService b;

    private l(TiebaActiveService tiebaActiveService) {
        this.b = tiebaActiveService;
        this.f2450a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(TiebaActiveService tiebaActiveService, k kVar) {
        this(tiebaActiveService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        bd.a(getClass().getName(), "doBackGround", "send active...");
        try {
            this.f2450a = new NetWorkCore(new aw());
            this.f2450a.b("http://114.113.149.3:8086/partnersService");
            this.f2450a.a(this.b.getApplicationContext());
            this.f2450a.a("apk", TiebaApplication.h().getPackageName());
            this.f2450a.a("imei", TiebaApplication.h().q());
            this.f2450a.a("model", Build.MODEL);
            this.f2450a.a("edition", com.baidu.tieba.data.h.j());
            this.f2450a.a("system", Build.VERSION.SDK);
            this.f2450a.e(false);
            String s = this.f2450a.s();
            if (this.f2450a.p()) {
                bd.a(getClass().getName(), "task", "data=" + s);
                return s;
            }
        } catch (Exception e) {
            com.baidu.tieba.sharedPref.b.a().b("active", 1);
            bd.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.f2435a = null;
        if (this.f2450a != null) {
            this.f2450a.r();
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
        this.b.f2435a = null;
        if (str == null) {
            TiebaActiveService.b(this.b);
            i = this.b.b;
            if (i < 10) {
                handler = this.b.c;
                runnable = this.b.d;
                handler.removeCallbacks(runnable);
                handler2 = this.b.c;
                runnable2 = this.b.d;
                handler2.postDelayed(runnable2, Util.MILLSECONDS_OF_MINUTE);
            } else {
                com.baidu.tieba.sharedPref.b.a().b("active", 1);
                this.b.stopSelf();
            }
        }
        bd.a(getClass().getName(), "onPostExecute", "send active ok");
        com.baidu.tieba.sharedPref.b.a().b("active", 2);
        this.b.stopSelf();
    }
}
