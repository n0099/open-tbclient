package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw extends AsyncTask {
    final /* synthetic */ PersonListActivity a;
    private String b;
    private boolean c;
    private int d;
    private com.baidu.tieba.c.t e = null;

    public bw(PersonListActivity personListActivity, String str, boolean z, int i) {
        this.a = personListActivity;
        this.b = str;
        this.c = z;
        this.d = i;
    }

    public void a() {
        com.baidu.tieba.write.k kVar;
        ProgressBar progressBar;
        com.baidu.tieba.write.k kVar2;
        com.baidu.tieba.write.k kVar3;
        if (this.e != null) {
            this.e.g();
        }
        kVar = this.a.f;
        if (kVar != null) {
            kVar2 = this.a.f;
            kVar2.b(false);
            kVar3 = this.a.f;
            kVar3.notifyDataSetChanged();
        }
        progressBar = this.a.e;
        progressBar.setVisibility(8);
        this.a.h = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.am doInBackground(String... strArr) {
        this.e = new com.baidu.tieba.c.t();
        if (this.c) {
            this.e.a("http://c.tieba.baidu.com/c/u/follow/page");
        } else {
            this.e.a("http://c.tieba.baidu.com/c/u/fans/page");
        }
        if (this.b != null && !this.b.equals(TiebaApplication.y())) {
            this.e.a("uid", this.b);
        }
        if (this.d != 0) {
            this.e.a("pn", String.valueOf(this.d));
        }
        String i = this.e.i();
        if (!this.e.b()) {
            return null;
        }
        com.baidu.tieba.a.am amVar = new com.baidu.tieba.a.am();
        amVar.a(i);
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.am amVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.v vVar;
        com.baidu.tieba.b.v vVar2;
        com.baidu.tieba.b.v vVar3;
        com.baidu.tieba.write.k kVar;
        com.baidu.tieba.b.v vVar4;
        com.baidu.tieba.write.k kVar2;
        com.baidu.tieba.write.k kVar3;
        com.baidu.tieba.write.k kVar4;
        com.baidu.tieba.write.k kVar5;
        com.baidu.tieba.write.k kVar6;
        progressBar = this.a.e;
        progressBar.setVisibility(8);
        this.a.h = null;
        if (this.e != null) {
            if (this.e.b()) {
                vVar = this.a.i;
                if (vVar != null && amVar != null) {
                    vVar2 = this.a.i;
                    vVar2.c().b().addAll(amVar.b());
                    vVar3 = this.a.i;
                    vVar3.c().a(amVar.a());
                    kVar = this.a.f;
                    if (kVar != null) {
                        vVar4 = this.a.i;
                        com.baidu.tieba.a.aj a = vVar4.c().a();
                        if (a == null || a.c() != 1) {
                            kVar2 = this.a.f;
                            kVar2.a(false);
                        } else {
                            kVar6 = this.a.f;
                            kVar6.a(true);
                        }
                        kVar3 = this.a.f;
                        kVar3.b(false);
                        kVar4 = this.a.f;
                        kVar4.b();
                        kVar5 = this.a.f;
                        kVar5.notifyDataSetChanged();
                    }
                    if (!this.c) {
                        TiebaApplication.b().g(0L);
                    }
                }
            } else {
                this.a.b(this.e.f());
            }
            super.onPostExecute(amVar);
        }
    }
}
