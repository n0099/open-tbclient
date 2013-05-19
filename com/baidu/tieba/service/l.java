package com.baidu.tieba.service;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.adp.lib.a.a {
    w a;
    final /* synthetic */ TiebaActiveService b;

    private l(TiebaActiveService tiebaActiveService) {
        this.b = tiebaActiveService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(TiebaActiveService tiebaActiveService, l lVar) {
        this(tiebaActiveService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(String... strArr) {
        ae.a(getClass().getName(), "doBackGround", "send active...");
        try {
            this.a = new w("http://114.113.149.3:8086/partnersService");
            this.a.a("http://114.113.149.3:8086/partnersService");
            this.a.b(this.b.getApplicationContext());
            this.a.a("apk", TiebaApplication.d().getPackageName());
            this.a.a("imei", TiebaApplication.d().k());
            this.a.a("model", Build.MODEL);
            this.a.a("edition", com.baidu.tieba.a.i.h());
            this.a.a("system", Build.VERSION.SDK);
            this.a.c(false);
            String n = this.a.n();
            if (this.a.g()) {
                ae.a(getClass().getName(), "task", "data=" + n);
                return n;
            }
        } catch (Exception e) {
            SharedPreferences.Editor edit = this.b.getSharedPreferences("settings", 0).edit();
            edit.putInt("active", 1);
            edit.commit();
            ae.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        this.b.a = null;
        if (this.a != null) {
            this.a.k();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        super.a((Object) str);
        this.b.a = null;
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
        ae.a(getClass().getName(), "onPostExecute", "send active ok");
        edit.putInt("active", 2);
        edit.commit();
        this.b.stopSelf();
    }
}
