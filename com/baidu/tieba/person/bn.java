package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends AsyncTask {
    final /* synthetic */ PersonLbsActivity a;
    private int b;
    private int c;
    private com.baidu.tieba.c.t d = null;

    public bn(PersonLbsActivity personLbsActivity, int i, int i2) {
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
        bo boVar;
        com.baidu.tieba.b.u uVar;
        int i;
        com.baidu.tieba.b.u uVar2;
        com.baidu.tieba.b.u uVar3;
        com.baidu.tieba.b.u uVar4;
        bo boVar2;
        bo boVar3;
        com.baidu.tieba.b.u uVar5;
        com.baidu.tieba.b.u uVar6;
        com.baidu.tieba.b.u uVar7;
        int i2;
        com.baidu.tieba.b.u uVar8;
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
            boVar3 = this.a.n;
            boVar3.a(true);
            uVar5 = this.a.p;
            if (uVar5 != null) {
                uVar6 = this.a.p;
                int size = uVar6.a().size();
                if (size > 200) {
                    for (int i3 = 0; i3 < 20 && i3 < size; i3++) {
                        uVar8 = this.a.p;
                        uVar8.a().remove(0);
                    }
                    uVar7 = this.a.p;
                    uVar7.b().b(1);
                    PersonLbsActivity personLbsActivity = this.a;
                    i2 = personLbsActivity.r;
                    personLbsActivity.r = i2 + 1;
                }
            }
        } else {
            boVar = this.a.n;
            boVar.b(true);
            uVar = this.a.p;
            if (uVar != null) {
                uVar2 = this.a.p;
                int size2 = uVar2.a().size();
                if (size2 > 200) {
                    for (int i4 = 0; i4 < 20 && i4 < size2; i4++) {
                        uVar4 = this.a.p;
                        uVar4.a().remove((size2 - i4) - 1);
                    }
                }
                uVar3 = this.a.p;
                uVar3.b().a(1);
            }
            PersonLbsActivity personLbsActivity2 = this.a;
            i = personLbsActivity2.s;
            personLbsActivity2.s = i - 1;
        }
        boVar2 = this.a.n;
        boVar2.notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.u uVar) {
        bo boVar;
        com.baidu.tieba.b.u uVar2;
        bo boVar2;
        com.baidu.tieba.b.u uVar3;
        TextView textView;
        com.baidu.tieba.b.u uVar4;
        com.baidu.tieba.b.u uVar5;
        com.baidu.tieba.b.u uVar6;
        com.baidu.tieba.b.u uVar7;
        bo boVar3;
        com.baidu.tieba.b.u uVar8;
        bo boVar4;
        com.baidu.tieba.b.u uVar9;
        com.baidu.tieba.b.u uVar10;
        super.onPostExecute(uVar);
        this.a.o = null;
        c();
        if (uVar == null) {
            if (this.d != null) {
                this.a.b(this.d.f());
                return;
            }
            return;
        }
        if (this.c != 0) {
            uVar5 = this.a.p;
            if (uVar5 != null) {
                if (this.c == 1) {
                    ArrayList a = uVar.a();
                    uVar9 = this.a.p;
                    uVar9.a().addAll(0, a);
                    uVar10 = this.a.p;
                    uVar10.b().b(uVar.b().d());
                    this.a.r = this.b;
                } else {
                    ArrayList a2 = uVar.a();
                    uVar6 = this.a.p;
                    uVar6.a().addAll(a2);
                    uVar7 = this.a.p;
                    uVar7.b().a(uVar.b().c());
                    this.a.s = this.b;
                }
                boVar3 = this.a.n;
                uVar8 = this.a.p;
                boVar3.a(uVar8);
                boVar4 = this.a.n;
                boVar4.notifyDataSetChanged();
                return;
            }
        }
        this.a.p = uVar;
        boVar = this.a.n;
        uVar2 = this.a.p;
        boVar.a(uVar2);
        boVar2 = this.a.n;
        boVar2.notifyDataSetInvalidated();
        PersonLbsActivity personLbsActivity = this.a;
        PersonLbsActivity personLbsActivity2 = this.a;
        int i = this.b;
        personLbsActivity2.s = i;
        personLbsActivity.r = i;
        uVar3 = this.a.p;
        if (uVar3 != null) {
            uVar4 = this.a.p;
            if (uVar4.a().size() != 0) {
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
    public com.baidu.tieba.b.u doInBackground(String... strArr) {
        String str;
        this.d = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/u/feed/ssf");
        com.baidu.tieba.c.t tVar = this.d;
        str = this.a.l;
        tVar.a("uid", str);
        this.d.a("rn", String.valueOf(20));
        this.d.a("pn", String.valueOf(this.b));
        String i = this.d.i();
        if (this.d.b()) {
            com.baidu.tieba.b.u uVar = new com.baidu.tieba.b.u();
            uVar.a(i);
            int size = uVar.a().size();
            for (int i2 = 0; i2 < size; i2++) {
                ((com.baidu.tieba.a.al) uVar.a().get(i2)).c().a(this.a);
                ((com.baidu.tieba.a.al) uVar.a().get(i2)).c().a((ArrayList) null);
            }
            return uVar;
        }
        return null;
    }

    private void c() {
        bo boVar;
        bo boVar2;
        bo boVar3;
        ProgressBar progressBar;
        if (this.c == 0) {
            progressBar = this.a.i;
            progressBar.setVisibility(8);
            return;
        }
        if (this.c == 2) {
            boVar3 = this.a.n;
            boVar3.a(false);
        } else {
            boVar = this.a.n;
            boVar.b(false);
        }
        boVar2 = this.a.n;
        boVar2.notifyDataSetChanged();
    }

    public int b() {
        return this.c;
    }
}
