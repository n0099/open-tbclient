package com.baidu.tieba.service;

import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.ah;
import com.baidu.tieba.util.av;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    NetWorkCore f1794a;
    final /* synthetic */ TiebaActiveService b;

    private k(TiebaActiveService tiebaActiveService) {
        this.b = tiebaActiveService;
        this.f1794a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(TiebaActiveService tiebaActiveService, k kVar) {
        this(tiebaActiveService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        av.a(getClass().getName(), "doBackGround", "send active...");
        try {
            this.f1794a = new NetWorkCore(new ah());
            this.f1794a.a("http://114.113.149.3:8086/partnersService");
            this.f1794a.a(this.b.getApplicationContext());
            this.f1794a.a("apk", TiebaApplication.g().getPackageName());
            this.f1794a.a("imei", TiebaApplication.g().p());
            this.f1794a.a("model", Build.MODEL);
            this.f1794a.a("edition", com.baidu.tieba.data.g.j());
            this.f1794a.a("system", Build.VERSION.SDK);
            this.f1794a.d(false);
            String s = this.f1794a.s();
            if (this.f1794a.p()) {
                av.a(getClass().getName(), "task", "data=" + s);
                return s;
            }
        } catch (Exception e) {
            com.baidu.tieba.sharedPref.b.a().b("active", 1);
            av.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.f1779a = null;
        if (this.f1794a != null) {
            this.f1794a.r();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        super.a((k) str);
        this.b.f1779a = null;
        if (str == null) {
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
                handler2.postDelayed(runnable2, Util.MILLSECONDS_OF_MINUTE);
            } else {
                com.baidu.tieba.sharedPref.b.a().b("active", 1);
                this.b.stopSelf();
            }
        }
        av.a(getClass().getName(), "onPostExecute", "send active ok");
        com.baidu.tieba.sharedPref.b.a().b("active", 2);
        this.b.stopSelf();
    }
}
