package com.baidu.tieba.person;

import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends com.baidu.adp.lib.a.a {
    final /* synthetic */ PersonLbsActivity a;
    private int b;
    private int c;
    private com.baidu.tieba.d.t d = null;

    public bh(PersonLbsActivity personLbsActivity, int i, int i2) {
        this.a = personLbsActivity;
        this.b = 0;
        this.c = 0;
        this.b = i < 1 ? 1 : i;
        this.c = i2;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        super.cancel(true);
        this.a.o = null;
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        bi biVar;
        com.baidu.tieba.c.bi biVar2;
        int i;
        com.baidu.tieba.c.bi biVar3;
        com.baidu.tieba.c.bi biVar4;
        com.baidu.tieba.c.bi biVar5;
        bi biVar6;
        bi biVar7;
        com.baidu.tieba.c.bi biVar8;
        com.baidu.tieba.c.bi biVar9;
        com.baidu.tieba.c.bi biVar10;
        int i2;
        com.baidu.tieba.c.bi biVar11;
        TextView textView;
        ProgressBar progressBar;
        super.b();
        if (this.c == 0) {
            textView = this.a.f;
            textView.setVisibility(8);
            progressBar = this.a.i;
            progressBar.setVisibility(0);
            return;
        }
        if (this.c == 2) {
            biVar7 = this.a.n;
            biVar7.a(true);
            biVar8 = this.a.p;
            if (biVar8 != null) {
                biVar9 = this.a.p;
                int size = biVar9.a().size();
                if (size > 200) {
                    for (int i3 = 0; i3 < 20 && i3 < size; i3++) {
                        biVar11 = this.a.p;
                        biVar11.a().remove(0);
                    }
                    biVar10 = this.a.p;
                    biVar10.b().f(1);
                    PersonLbsActivity personLbsActivity = this.a;
                    i2 = personLbsActivity.r;
                    personLbsActivity.r = i2 + 1;
                }
            }
        } else {
            biVar = this.a.n;
            biVar.b(true);
            biVar2 = this.a.p;
            if (biVar2 != null) {
                biVar3 = this.a.p;
                int size2 = biVar3.a().size();
                if (size2 > 200) {
                    for (int i4 = 0; i4 < 20 && i4 < size2; i4++) {
                        biVar5 = this.a.p;
                        biVar5.a().remove((size2 - i4) - 1);
                    }
                }
                biVar4 = this.a.p;
                biVar4.b().e(1);
            }
            PersonLbsActivity personLbsActivity2 = this.a;
            i = personLbsActivity2.s;
            personLbsActivity2.s = i - 1;
        }
        biVar6 = this.a.n;
        biVar6.notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.c.bi biVar) {
        bi biVar2;
        com.baidu.tieba.c.bi biVar3;
        bi biVar4;
        com.baidu.tieba.c.bi biVar5;
        TextView textView;
        com.baidu.tieba.c.bi biVar6;
        com.baidu.tieba.c.bi biVar7;
        com.baidu.tieba.c.bi biVar8;
        com.baidu.tieba.c.bi biVar9;
        bi biVar10;
        com.baidu.tieba.c.bi biVar11;
        bi biVar12;
        com.baidu.tieba.c.bi biVar13;
        com.baidu.tieba.c.bi biVar14;
        super.a((Object) biVar);
        this.a.o = null;
        f();
        if (biVar == null) {
            if (this.d != null) {
                this.a.a(this.d.f());
                return;
            }
            return;
        }
        if (this.c != 0) {
            biVar7 = this.a.p;
            if (biVar7 != null) {
                if (this.c == 1) {
                    ArrayList a = biVar.a();
                    biVar13 = this.a.p;
                    biVar13.a().addAll(0, a);
                    biVar14 = this.a.p;
                    biVar14.b().f(biVar.b().f());
                    this.a.r = this.b;
                } else {
                    ArrayList a2 = biVar.a();
                    biVar8 = this.a.p;
                    biVar8.a().addAll(a2);
                    biVar9 = this.a.p;
                    biVar9.b().e(biVar.b().e());
                    this.a.s = this.b;
                }
                biVar10 = this.a.n;
                biVar11 = this.a.p;
                biVar10.a(biVar11);
                biVar12 = this.a.n;
                biVar12.notifyDataSetChanged();
                return;
            }
        }
        this.a.p = biVar;
        biVar2 = this.a.n;
        biVar3 = this.a.p;
        biVar2.a(biVar3);
        biVar4 = this.a.n;
        biVar4.notifyDataSetInvalidated();
        PersonLbsActivity personLbsActivity = this.a;
        PersonLbsActivity personLbsActivity2 = this.a;
        int i = this.b;
        personLbsActivity2.s = i;
        personLbsActivity.r = i;
        biVar5 = this.a.p;
        if (biVar5 != null) {
            biVar6 = this.a.p;
            if (biVar6.a().size() != 0) {
                return;
            }
        }
        textView = this.a.f;
        textView.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public com.baidu.tieba.c.bi a(String... strArr) {
        String str;
        this.d = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/u/feed/ssf");
        com.baidu.tieba.d.t tVar = this.d;
        str = this.a.l;
        tVar.a("uid", str);
        this.d.a("rn", String.valueOf(20));
        this.d.a("pn", String.valueOf(this.b));
        String i = this.d.i();
        if (this.d.b()) {
            com.baidu.tieba.c.bi biVar = new com.baidu.tieba.c.bi();
            biVar.a(i);
            int size = biVar.a().size();
            for (int i2 = 0; i2 < size; i2++) {
                ((com.baidu.tieba.a.ao) biVar.a().get(i2)).e().c(this.a);
                ((com.baidu.tieba.a.ao) biVar.a().get(i2)).e().a((ArrayList) null);
            }
            return biVar;
        }
        return null;
    }

    private void f() {
        bi biVar;
        bi biVar2;
        bi biVar3;
        ProgressBar progressBar;
        if (this.c == 0) {
            progressBar = this.a.i;
            progressBar.setVisibility(8);
            return;
        }
        if (this.c == 2) {
            biVar3 = this.a.n;
            biVar3.a(false);
        } else {
            biVar = this.a.n;
            biVar.b(false);
        }
        biVar2 = this.a.n;
        biVar2.notifyDataSetChanged();
    }

    public int e() {
        return this.c;
    }
}
