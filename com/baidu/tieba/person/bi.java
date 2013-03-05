package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends AsyncTask {
    final /* synthetic */ PersonLbsActivity a;
    private int b;
    private int c;
    private com.baidu.tieba.c.t d = null;

    public bi(PersonLbsActivity personLbsActivity, int i, int i2) {
        this.a = personLbsActivity;
        this.b = 0;
        this.c = 0;
        this.b = i < 1 ? 1 : i;
        this.c = i2;
    }

    public void a() {
        super.cancel(true);
        this.a.o = null;
        c();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        bj bjVar;
        com.baidu.tieba.b.t tVar;
        int i;
        com.baidu.tieba.b.t tVar2;
        com.baidu.tieba.b.t tVar3;
        com.baidu.tieba.b.t tVar4;
        bj bjVar2;
        bj bjVar3;
        com.baidu.tieba.b.t tVar5;
        com.baidu.tieba.b.t tVar6;
        com.baidu.tieba.b.t tVar7;
        int i2;
        com.baidu.tieba.b.t tVar8;
        TextView textView;
        ProgressBar progressBar;
        super.onPreExecute();
        if (this.c == 0) {
            textView = this.a.f;
            textView.setVisibility(8);
            progressBar = this.a.i;
            progressBar.setVisibility(0);
            return;
        }
        if (this.c == 2) {
            bjVar3 = this.a.n;
            bjVar3.a(true);
            tVar5 = this.a.p;
            if (tVar5 != null) {
                tVar6 = this.a.p;
                int size = tVar6.a().size();
                if (size > 200) {
                    for (int i3 = 0; i3 < 20 && i3 < size; i3++) {
                        tVar8 = this.a.p;
                        tVar8.a().remove(0);
                    }
                    tVar7 = this.a.p;
                    tVar7.b().b(1);
                    PersonLbsActivity personLbsActivity = this.a;
                    i2 = personLbsActivity.r;
                    personLbsActivity.r = i2 + 1;
                }
            }
        } else {
            bjVar = this.a.n;
            bjVar.b(true);
            tVar = this.a.p;
            if (tVar != null) {
                tVar2 = this.a.p;
                int size2 = tVar2.a().size();
                if (size2 > 200) {
                    for (int i4 = 0; i4 < 20 && i4 < size2; i4++) {
                        tVar4 = this.a.p;
                        tVar4.a().remove((size2 - i4) - 1);
                    }
                }
                tVar3 = this.a.p;
                tVar3.b().a(1);
            }
            PersonLbsActivity personLbsActivity2 = this.a;
            i = personLbsActivity2.s;
            personLbsActivity2.s = i - 1;
        }
        bjVar2 = this.a.n;
        bjVar2.notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.t tVar) {
        bj bjVar;
        com.baidu.tieba.b.t tVar2;
        bj bjVar2;
        com.baidu.tieba.b.t tVar3;
        TextView textView;
        com.baidu.tieba.b.t tVar4;
        com.baidu.tieba.b.t tVar5;
        com.baidu.tieba.b.t tVar6;
        com.baidu.tieba.b.t tVar7;
        bj bjVar3;
        com.baidu.tieba.b.t tVar8;
        bj bjVar4;
        com.baidu.tieba.b.t tVar9;
        com.baidu.tieba.b.t tVar10;
        super.onPostExecute(tVar);
        this.a.o = null;
        c();
        if (tVar == null) {
            if (this.d != null) {
                this.a.b(this.d.f());
                return;
            }
            return;
        }
        if (this.c != 0) {
            tVar5 = this.a.p;
            if (tVar5 != null) {
                if (this.c == 1) {
                    ArrayList a = tVar.a();
                    tVar9 = this.a.p;
                    tVar9.a().addAll(0, a);
                    tVar10 = this.a.p;
                    tVar10.b().b(tVar.b().d());
                    this.a.r = this.b;
                } else {
                    ArrayList a2 = tVar.a();
                    tVar6 = this.a.p;
                    tVar6.a().addAll(a2);
                    tVar7 = this.a.p;
                    tVar7.b().a(tVar.b().c());
                    this.a.s = this.b;
                }
                bjVar3 = this.a.n;
                tVar8 = this.a.p;
                bjVar3.a(tVar8);
                bjVar4 = this.a.n;
                bjVar4.notifyDataSetChanged();
                return;
            }
        }
        this.a.p = tVar;
        bjVar = this.a.n;
        tVar2 = this.a.p;
        bjVar.a(tVar2);
        bjVar2 = this.a.n;
        bjVar2.notifyDataSetInvalidated();
        PersonLbsActivity personLbsActivity = this.a;
        PersonLbsActivity personLbsActivity2 = this.a;
        int i = this.b;
        personLbsActivity2.s = i;
        personLbsActivity.r = i;
        tVar3 = this.a.p;
        if (tVar3 != null) {
            tVar4 = this.a.p;
            if (tVar4.a().size() != 0) {
                return;
            }
        }
        textView = this.a.f;
        textView.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.t doInBackground(String... strArr) {
        String str;
        this.d = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/u/feed/ssf");
        com.baidu.tieba.c.t tVar = this.d;
        str = this.a.l;
        tVar.a("uid", str);
        this.d.a("rn", String.valueOf(20));
        this.d.a("pn", String.valueOf(this.b));
        String i = this.d.i();
        if (this.d.b()) {
            com.baidu.tieba.b.t tVar2 = new com.baidu.tieba.b.t();
            tVar2.a(i);
            int size = tVar2.a().size();
            for (int i2 = 0; i2 < size; i2++) {
                ((com.baidu.tieba.a.aj) tVar2.a().get(i2)).c().a(this.a);
                ((com.baidu.tieba.a.aj) tVar2.a().get(i2)).c().a((ArrayList) null);
            }
            return tVar2;
        }
        return null;
    }

    private void c() {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        ProgressBar progressBar;
        if (this.c == 0) {
            progressBar = this.a.i;
            progressBar.setVisibility(8);
            return;
        }
        if (this.c == 2) {
            bjVar3 = this.a.n;
            bjVar3.a(false);
        } else {
            bjVar = this.a.n;
            bjVar.b(false);
        }
        bjVar2 = this.a.n;
        bjVar2.notifyDataSetChanged();
    }

    public int b() {
        return this.c;
    }
}
