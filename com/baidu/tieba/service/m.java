package com.baidu.tieba.service;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.aj;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    NetWorkCore f1705a;
    final /* synthetic */ TiebaActiveService b;

    private m(TiebaActiveService tiebaActiveService) {
        this.b = tiebaActiveService;
        this.f1705a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(TiebaActiveService tiebaActiveService, m mVar) {
        this(tiebaActiveService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        aj.a(getClass().getName(), "doBackGround", "send active...");
        try {
            this.f1705a = new NetWorkCore("http://114.113.149.3:8086/partnersService");
            this.f1705a.a("http://114.113.149.3:8086/partnersService");
            this.f1705a.b(this.b.getApplicationContext());
            this.f1705a.a("apk", TiebaApplication.f().getPackageName());
            this.f1705a.a("imei", TiebaApplication.f().p());
            this.f1705a.a("model", Build.MODEL);
            this.f1705a.a("edition", com.baidu.tieba.data.g.i());
            this.f1705a.a("system", Build.VERSION.SDK);
            this.f1705a.c(false);
            String v = this.f1705a.v();
            if (this.f1705a.o()) {
                aj.a(getClass().getName(), "task", "data=" + v);
                return v;
            }
        } catch (Exception e) {
            SharedPreferences.Editor edit = this.b.getSharedPreferences("settings", 0).edit();
            edit.putInt("active", 1);
            edit.commit();
            aj.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.f1688a = null;
        if (this.f1705a != null) {
            this.f1705a.s();
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
        this.b.f1688a = null;
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
                handler2.postDelayed(runnable2, Util.MILLSECONDS_OF_MINUTE);
            } else {
                edit.commit();
                this.b.stopSelf();
            }
        }
        aj.a(getClass().getName(), "onPostExecute", "send active ok");
        edit.putInt("active", 2);
        edit.commit();
        this.b.stopSelf();
    }
}
