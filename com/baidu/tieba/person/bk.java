package com.baidu.tieba.person;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.bq;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1596a;
    private String b;
    private boolean c;
    private int d;
    private com.baidu.tieba.util.u e = null;

    public bk(PersonListActivity personListActivity, String str, boolean z, int i) {
        this.f1596a = personListActivity;
        this.b = str;
        this.c = z;
        this.d = i;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bl blVar;
        ProgressBar progressBar;
        bl blVar2;
        bl blVar3;
        if (this.e != null) {
            this.e.i();
        }
        blVar = this.f1596a.f;
        if (blVar != null) {
            blVar2 = this.f1596a.f;
            blVar2.b(false);
            blVar3 = this.f1596a.f;
            blVar3.notifyDataSetChanged();
        }
        progressBar = this.f1596a.e;
        progressBar.setVisibility(8);
        this.f1596a.j = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.au a(String... strArr) {
        this.e = new com.baidu.tieba.util.u();
        if (this.c) {
            this.e.a(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/u/follow/page");
        } else {
            this.e.a(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/u/fans/page");
        }
        if (this.b != null && !this.b.equals(TiebaApplication.E())) {
            this.e.a("uid", this.b);
        }
        if (this.d != 0) {
            this.e.a("pn", String.valueOf(this.d));
        }
        String k = this.e.k();
        if (!this.e.d()) {
            return null;
        }
        com.baidu.tieba.data.au auVar = new com.baidu.tieba.data.au();
        auVar.a(k);
        return auVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.au auVar) {
        ProgressBar progressBar;
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bl blVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        bq bqVar4;
        String string;
        String string2;
        bq bqVar5;
        bq bqVar6;
        bq bqVar7;
        bq bqVar8;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        bl blVar6;
        progressBar = this.f1596a.e;
        progressBar.setVisibility(8);
        this.f1596a.j = null;
        if (this.e != null) {
            if (this.e.d()) {
                bqVar = this.f1596a.k;
                if (bqVar != null && auVar != null) {
                    bqVar2 = this.f1596a.k;
                    bqVar2.c().b().addAll(auVar.b());
                    bqVar3 = this.f1596a.k;
                    bqVar3.c().a(auVar.a());
                    blVar = this.f1596a.f;
                    if (blVar != null) {
                        bqVar8 = this.f1596a.k;
                        com.baidu.tieba.data.ar a2 = bqVar8.c().a();
                        if (a2 == null || a2.f() != 1) {
                            blVar2 = this.f1596a.f;
                            blVar2.a(false);
                        } else {
                            blVar6 = this.f1596a.f;
                            blVar6.a(true);
                        }
                        blVar3 = this.f1596a.f;
                        blVar3.b(false);
                        blVar4 = this.f1596a.f;
                        blVar4.b();
                        blVar5 = this.f1596a.f;
                        blVar5.notifyDataSetChanged();
                    }
                    if (!this.c) {
                        TiebaApplication.f().e(0L);
                    }
                    if (this.d == 0) {
                        if (auVar.a().c() > 0) {
                            linearLayout2 = this.f1596a.d;
                            linearLayout2.setVisibility(0);
                            linearLayout3 = this.f1596a.d;
                            TextView textView = (TextView) linearLayout3.findViewById(R.id.person_num);
                            if (this.c) {
                                bqVar6 = this.f1596a.k;
                                if (bqVar6.a() != null) {
                                    bqVar7 = this.f1596a.k;
                                    if (bqVar7.a().equals(TiebaApplication.E())) {
                                        string = this.f1596a.getString(R.string.my_attention_prefix);
                                        string2 = this.f1596a.getString(R.string.person);
                                    }
                                }
                                string = this.f1596a.getString(R.string.its_attention_prefix);
                                string2 = this.f1596a.getString(R.string.person);
                            } else {
                                bqVar4 = this.f1596a.k;
                                if (bqVar4.a() != null) {
                                    bqVar5 = this.f1596a.k;
                                    if (bqVar5.a().equals(TiebaApplication.E())) {
                                        string = this.f1596a.getString(R.string.my_fans_prefix);
                                        string2 = this.f1596a.getString(R.string.fans);
                                    }
                                }
                                string = this.f1596a.getString(R.string.its_fans_prefix);
                                string2 = this.f1596a.getString(R.string.fans);
                            }
                            textView.setText(String.valueOf(string) + String.valueOf(auVar.a().c()) + string2);
                        } else {
                            linearLayout = this.f1596a.d;
                            linearLayout.setVisibility(8);
                        }
                    }
                }
            } else {
                this.f1596a.a(this.e.h());
            }
            super.a((Object) auVar);
        }
    }
}
