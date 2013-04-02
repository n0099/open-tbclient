package com.baidu.tieba.mention;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.a.ak;
import com.baidu.tieba.a.an;
import com.baidu.tieba.a.at;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends AsyncTask {
    ArrayList a;
    final /* synthetic */ h b;
    private com.baidu.tieba.c.t c = null;
    private String d;
    private String e;
    private int f;

    public q(h hVar, String str, ArrayList arrayList, int i, String str2) {
        this.b = hVar;
        this.d = null;
        this.e = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
        this.f = i;
        this.e = str2;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        super.onPreExecute();
        progressBar = this.b.l;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        try {
            this.c = new com.baidu.tieba.c.t(this.d);
            this.c.a(this.a);
            return this.c.i();
        } catch (Exception e) {
            ag.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.e eVar;
        com.baidu.tieba.e eVar2;
        com.baidu.tieba.e eVar3;
        com.baidu.tieba.e eVar4;
        try {
            progressBar = this.b.l;
            progressBar.setVisibility(8);
            if (this.c != null && this.c.b()) {
                if (this.f == 1) {
                    ak akVar = new ak();
                    akVar.a(str);
                    an anVar = (an) akVar.d().get(0);
                    if (anVar != null) {
                        eVar4 = this.b.b;
                        WriteActivity.a(eVar4, akVar.a().b(), akVar.a().c(), akVar.b().a(), anVar.a(), anVar.c(), this.e, akVar.f(), akVar.k());
                    } else {
                        return;
                    }
                }
                if (this.f == 2) {
                    eVar2 = this.b.b;
                    at a = new com.baidu.tieba.b.w(eVar2, str).a();
                    String b = a.f().b();
                    String c = a.f().c();
                    String a2 = a.h().a();
                    com.baidu.tieba.a.b g = a.g();
                    String a3 = a.a().a();
                    int c2 = a.a().c();
                    eVar3 = this.b.b;
                    WriteActivity.a(eVar3, b, c, a2, a3, c2, this.e, g, true);
                }
            } else if (this.c != null) {
                eVar = this.b.b;
                eVar.b(this.c.f());
            }
        } catch (Exception e) {
        }
        this.b.m = null;
    }

    public void a() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.g();
        }
        progressBar = this.b.l;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
