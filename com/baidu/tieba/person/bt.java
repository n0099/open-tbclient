package com.baidu.tieba.person;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1353a;
    private String b;
    private boolean c;
    private int d;
    private com.baidu.tieba.util.r e = null;

    public bt(PersonListActivity personListActivity, String str, boolean z, int i) {
        this.f1353a = personListActivity;
        this.b = str;
        this.c = z;
        this.d = i;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bu buVar;
        ProgressBar progressBar;
        bu buVar2;
        bu buVar3;
        if (this.e != null) {
            this.e.h();
        }
        buVar = this.f1353a.f;
        if (buVar != null) {
            buVar2 = this.f1353a.f;
            buVar2.b(false);
            buVar3 = this.f1353a.f;
            buVar3.notifyDataSetChanged();
        }
        progressBar = this.f1353a.e;
        progressBar.setVisibility(8);
        this.f1353a.j = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.am a(String... strArr) {
        this.e = new com.baidu.tieba.util.r();
        if (this.c) {
            this.e.a(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/u/follow/page");
        } else {
            this.e.a(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/u/fans/page");
        }
        if (this.b != null && !this.b.equals(TiebaApplication.E())) {
            this.e.a("uid", this.b);
        }
        if (this.d != 0) {
            this.e.a("pn", String.valueOf(this.d));
        }
        String j = this.e.j();
        if (!this.e.c()) {
            return null;
        }
        com.baidu.tieba.data.am amVar = new com.baidu.tieba.data.am();
        amVar.a(j);
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.am amVar) {
        ProgressBar progressBar;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        com.baidu.tieba.model.bm bmVar3;
        bu buVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        com.baidu.tieba.model.bm bmVar4;
        String string;
        String string2;
        com.baidu.tieba.model.bm bmVar5;
        com.baidu.tieba.model.bm bmVar6;
        com.baidu.tieba.model.bm bmVar7;
        com.baidu.tieba.model.bm bmVar8;
        bu buVar2;
        bu buVar3;
        bu buVar4;
        bu buVar5;
        bu buVar6;
        progressBar = this.f1353a.e;
        progressBar.setVisibility(8);
        this.f1353a.j = null;
        if (this.e != null) {
            if (this.e.c()) {
                bmVar = this.f1353a.k;
                if (bmVar != null && amVar != null) {
                    bmVar2 = this.f1353a.k;
                    bmVar2.c().b().addAll(amVar.b());
                    bmVar3 = this.f1353a.k;
                    bmVar3.c().a(amVar.a());
                    buVar = this.f1353a.f;
                    if (buVar != null) {
                        bmVar8 = this.f1353a.k;
                        com.baidu.tieba.data.ai a2 = bmVar8.c().a();
                        if (a2 == null || a2.f() != 1) {
                            buVar2 = this.f1353a.f;
                            buVar2.a(false);
                        } else {
                            buVar6 = this.f1353a.f;
                            buVar6.a(true);
                        }
                        buVar3 = this.f1353a.f;
                        buVar3.b(false);
                        buVar4 = this.f1353a.f;
                        buVar4.b();
                        buVar5 = this.f1353a.f;
                        buVar5.notifyDataSetChanged();
                    }
                    if (!this.c) {
                        TiebaApplication.f().f(0L);
                    }
                    if (this.d == 0) {
                        if (amVar.a().c() > 0) {
                            linearLayout2 = this.f1353a.d;
                            linearLayout2.setVisibility(0);
                            linearLayout3 = this.f1353a.d;
                            TextView textView = (TextView) linearLayout3.findViewById(R.id.person_num);
                            if (this.c) {
                                bmVar6 = this.f1353a.k;
                                if (bmVar6.a() != null) {
                                    bmVar7 = this.f1353a.k;
                                    if (bmVar7.a().equals(TiebaApplication.E())) {
                                        string = this.f1353a.getString(R.string.my_attention_prefix);
                                        string2 = this.f1353a.getString(R.string.person);
                                    }
                                }
                                string = this.f1353a.getString(R.string.its_attention_prefix);
                                string2 = this.f1353a.getString(R.string.person);
                            } else {
                                bmVar4 = this.f1353a.k;
                                if (bmVar4.a() != null) {
                                    bmVar5 = this.f1353a.k;
                                    if (bmVar5.a().equals(TiebaApplication.E())) {
                                        string = this.f1353a.getString(R.string.my_fans_prefix);
                                        string2 = this.f1353a.getString(R.string.fans);
                                    }
                                }
                                string = this.f1353a.getString(R.string.its_fans_prefix);
                                string2 = this.f1353a.getString(R.string.fans);
                            }
                            textView.setText(String.valueOf(string) + String.valueOf(amVar.a().c()) + string2);
                        } else {
                            linearLayout = this.f1353a.d;
                            linearLayout.setVisibility(8);
                        }
                    }
                }
            } else {
                this.f1353a.a(this.e.g());
            }
            super.a((Object) amVar);
        }
    }
}
