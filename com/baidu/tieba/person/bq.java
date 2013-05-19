package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq extends com.baidu.adp.lib.a.a {
    final /* synthetic */ PersonListActivity a;
    private String b;
    private boolean c;
    private int d;
    private com.baidu.tieba.d.t e = null;

    public bq(PersonListActivity personListActivity, String str, boolean z, int i) {
        this.a = personListActivity;
        this.b = str;
        this.c = z;
        this.d = i;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
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
    @Override // com.baidu.adp.lib.a.a
    public com.baidu.tieba.a.ap a(String... strArr) {
        this.e = new com.baidu.tieba.d.t();
        if (this.c) {
            this.e.a(String.valueOf(com.baidu.tieba.a.i.e) + "c/u/follow/page");
        } else {
            this.e.a(String.valueOf(com.baidu.tieba.a.i.e) + "c/u/fans/page");
        }
        if (this.b != null && !this.b.equals(TiebaApplication.z())) {
            this.e.a("uid", this.b);
        }
        if (this.d != 0) {
            this.e.a("pn", String.valueOf(this.d));
        }
        String i = this.e.i();
        if (!this.e.b()) {
            return null;
        }
        com.baidu.tieba.a.ap apVar = new com.baidu.tieba.a.ap();
        apVar.a(i);
        return apVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.ap apVar) {
        ProgressBar progressBar;
        com.baidu.tieba.c.bj bjVar;
        com.baidu.tieba.c.bj bjVar2;
        com.baidu.tieba.c.bj bjVar3;
        com.baidu.tieba.write.k kVar;
        com.baidu.tieba.c.bj bjVar4;
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
                bjVar = this.a.i;
                if (bjVar != null && apVar != null) {
                    bjVar2 = this.a.i;
                    bjVar2.c().b().addAll(apVar.b());
                    bjVar3 = this.a.i;
                    bjVar3.c().a(apVar.a());
                    kVar = this.a.f;
                    if (kVar != null) {
                        bjVar4 = this.a.i;
                        com.baidu.tieba.a.ak a = bjVar4.c().a();
                        if (a == null || a.e() != 1) {
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
                        TiebaApplication.d().f(0L);
                    }
                }
            } else {
                this.a.a(this.e.f());
            }
            super.a((Object) apVar);
        }
    }
}
