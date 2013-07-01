package com.baidu.tieba.service;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    NetWorkCore f1415a;
    final /* synthetic */ TiebaActiveService b;

    private m(TiebaActiveService tiebaActiveService) {
        this.b = tiebaActiveService;
        this.f1415a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(TiebaActiveService tiebaActiveService, m mVar) {
        this(tiebaActiveService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        z.a(getClass().getName(), "doBackGround", "send active...");
        try {
            this.f1415a = new NetWorkCore("http://114.113.149.3:8086/partnersService");
            this.f1415a.a("http://114.113.149.3:8086/partnersService");
            this.f1415a.b(this.b.getApplicationContext());
            this.f1415a.a("apk", TiebaApplication.f().getPackageName());
            this.f1415a.a("imei", TiebaApplication.f().p());
            this.f1415a.a("model", Build.MODEL);
            this.f1415a.a("edition", com.baidu.tieba.data.g.i());
            this.f1415a.a("system", Build.VERSION.SDK);
            this.f1415a.c(false);
            String o = this.f1415a.o();
            if (this.f1415a.h()) {
                z.a(getClass().getName(), "task", "data=" + o);
                return o;
            }
        } catch (Exception e) {
            SharedPreferences.Editor edit = this.b.getSharedPreferences("settings", 0).edit();
            edit.putInt("active", 1);
            edit.commit();
            z.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.f1399a = null;
        if (this.f1415a != null) {
            this.f1415a.l();
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
        super.a((Object) str);
        this.b.f1399a = null;
        SharedPreferences.Editor edit = this.b.getSharedPreferences("settings", 0).edit();
        edit.putInt("active", 1);
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
                handler2.postDelayed(runnable2, 60000L);
            } else {
                edit.commit();
                this.b.stopSelf();
            }
        }
        z.a(getClass().getName(), "onPostExecute", "send active ok");
        edit.putInt("active", 2);
        edit.commit();
        this.b.stopSelf();
    }
}
