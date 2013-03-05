package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends AsyncTask {
    final /* synthetic */ PersonListActivity a;
    private String b;
    private boolean c;
    private int d;
    private com.baidu.tieba.c.t e = null;

    public br(PersonListActivity personListActivity, String str, boolean z, int i) {
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
    public com.baidu.tieba.a.ak doInBackground(String... strArr) {
        this.e = new com.baidu.tieba.c.t();
        if (this.c) {
            this.e.a("http://c.tieba.baidu.com/c/u/follow/page");
        } else {
            this.e.a("http://c.tieba.baidu.com/c/u/fans/page");
        }
        if (this.b != null && !this.b.equals(TiebaApplication.x())) {
            this.e.a("uid", this.b);
        }
        if (this.d != 0) {
            this.e.a("pn", String.valueOf(this.d));
        }
        String i = this.e.i();
        if (!this.e.b()) {
            return null;
        }
        com.baidu.tieba.a.ak akVar = new com.baidu.tieba.a.ak();
        akVar.a(i);
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.ak akVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.u uVar;
        com.baidu.tieba.b.u uVar2;
        com.baidu.tieba.b.u uVar3;
        com.baidu.tieba.write.k kVar;
        com.baidu.tieba.b.u uVar4;
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
                uVar = this.a.i;
                if (uVar != null && akVar != null) {
                    uVar2 = this.a.i;
                    uVar2.c().b().addAll(akVar.b());
                    uVar3 = this.a.i;
                    uVar3.c().a(akVar.a());
                    kVar = this.a.f;
                    if (kVar != null) {
                        uVar4 = this.a.i;
                        com.baidu.tieba.a.ah a = uVar4.c().a();
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
            super.onPostExecute(akVar);
        }
    }
}
