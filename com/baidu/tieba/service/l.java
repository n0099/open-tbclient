package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.az;
import com.baidu.tieba.util.bg;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    NetWorkCore f2333a;
    final /* synthetic */ TiebaActiveService b;

    private l(TiebaActiveService tiebaActiveService) {
        this.b = tiebaActiveService;
        this.f2333a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(TiebaActiveService tiebaActiveService, k kVar) {
        this(tiebaActiveService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        bg.a(getClass().getName(), "doBackGround", "send active...");
        try {
            this.f2333a = new NetWorkCore(new az());
            this.f2333a.b("http://114.113.149.3:8086/partnersService");
            this.f2333a.a(this.b.getApplicationContext());
            this.f2333a.a("apk", TiebaApplication.g().getPackageName());
            this.f2333a.a("imei", TiebaApplication.g().p());
            this.f2333a.a("model", Build.MODEL);
            this.f2333a.a("edition", com.baidu.tieba.data.h.j());
            this.f2333a.a("system", Build.VERSION.SDK);
            this.f2333a.e(false);
            String u = this.f2333a.u();
            if (this.f2333a.r()) {
                bg.a(getClass().getName(), "task", "data=" + u);
                return u;
            }
        } catch (Exception e) {
            com.baidu.tieba.sharedPref.b.a().b("active", 1);
            bg.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.f2318a = null;
        if (this.f2333a != null) {
            this.f2333a.t();
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
        this.b.f2318a = null;
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
        bg.a(getClass().getName(), "onPostExecute", "send active ok");
        com.baidu.tieba.sharedPref.b.a().b("active", 2);
        this.b.stopSelf();
    }
}
