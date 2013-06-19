package com.baidu.tieba.person;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.lib.a.a {
    final /* synthetic */ PersonListActivity a;
    private String b;
    private boolean c;
    private int d;
    private com.baidu.tieba.d.t e = null;

    public bs(PersonListActivity personListActivity, String str, boolean z, int i) {
        this.a = personListActivity;
        this.b = str;
        this.c = z;
        this.d = i;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        bt btVar;
        ProgressBar progressBar;
        bt btVar2;
        bt btVar3;
        if (this.e != null) {
            this.e.g();
        }
        btVar = this.a.h;
        if (btVar != null) {
            btVar2 = this.a.h;
            btVar2.b(false);
            btVar3 = this.a.h;
            btVar3.notifyDataSetChanged();
        }
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        this.a.j = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public com.baidu.tieba.a.aq a(String... strArr) {
        this.e = new com.baidu.tieba.d.t();
        if (this.c) {
            this.e.a(String.valueOf(com.baidu.tieba.a.i.e) + "c/u/follow/page");
        } else {
            this.e.a(String.valueOf(com.baidu.tieba.a.i.e) + "c/u/fans/page");
        }
        if (this.b != null && !this.b.equals(TiebaApplication.C())) {
            this.e.a("uid", this.b);
        }
        if (this.d != 0) {
            this.e.a("pn", String.valueOf(this.d));
        }
        String i = this.e.i();
        if (!this.e.b()) {
            return null;
        }
        com.baidu.tieba.a.aq aqVar = new com.baidu.tieba.a.aq();
        aqVar.a(i);
        return aqVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.aq aqVar) {
        ProgressBar progressBar;
        com.baidu.tieba.c.bm bmVar;
        com.baidu.tieba.c.bm bmVar2;
        com.baidu.tieba.c.bm bmVar3;
        bt btVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        com.baidu.tieba.c.bm bmVar4;
        String string;
        String string2;
        com.baidu.tieba.c.bm bmVar5;
        com.baidu.tieba.c.bm bmVar6;
        com.baidu.tieba.c.bm bmVar7;
        com.baidu.tieba.c.bm bmVar8;
        bt btVar2;
        bt btVar3;
        bt btVar4;
        bt btVar5;
        bt btVar6;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        this.a.j = null;
        if (this.e != null) {
            if (this.e.b()) {
                bmVar = this.a.k;
                if (bmVar != null && aqVar != null) {
                    bmVar2 = this.a.k;
                    bmVar2.c().b().addAll(aqVar.b());
                    bmVar3 = this.a.k;
                    bmVar3.c().a(aqVar.a());
                    btVar = this.a.h;
                    if (btVar != null) {
                        bmVar8 = this.a.k;
                        com.baidu.tieba.a.al a = bmVar8.c().a();
                        if (a == null || a.f() != 1) {
                            btVar2 = this.a.h;
                            btVar2.a(false);
                        } else {
                            btVar6 = this.a.h;
                            btVar6.a(true);
                        }
                        btVar3 = this.a.h;
                        btVar3.b(false);
                        btVar4 = this.a.h;
                        btVar4.b();
                        btVar5 = this.a.h;
                        btVar5.notifyDataSetChanged();
                    }
                    if (!this.c) {
                        TiebaApplication.e().f(0L);
                    }
                    if (this.d == 0) {
                        if (aqVar.a().c() > 0) {
                            linearLayout2 = this.a.f;
                            linearLayout2.setVisibility(0);
                            linearLayout3 = this.a.f;
                            TextView textView = (TextView) linearLayout3.findViewById(R.id.person_num);
                            if (this.c) {
                                bmVar6 = this.a.k;
                                if (bmVar6.a() != null) {
                                    bmVar7 = this.a.k;
                                    if (bmVar7.a().equals(TiebaApplication.C())) {
                                        string = this.a.getString(R.string.my_attention_prefix);
                                        string2 = this.a.getString(R.string.person);
                                    }
                                }
                                string = this.a.getString(R.string.its_attention_prefix);
                                string2 = this.a.getString(R.string.person);
                            } else {
                                bmVar4 = this.a.k;
                                if (bmVar4.a() != null) {
                                    bmVar5 = this.a.k;
                                    if (bmVar5.a().equals(TiebaApplication.C())) {
                                        string = this.a.getString(R.string.my_fans_prefix);
                                        string2 = this.a.getString(R.string.fans);
                                    }
                                }
                                string = this.a.getString(R.string.its_fans_prefix);
                                string2 = this.a.getString(R.string.fans);
                            }
                            textView.setText(String.valueOf(string) + String.valueOf(aqVar.a().c()) + string2);
                        } else {
                            linearLayout = this.a.f;
                            linearLayout.setVisibility(8);
                        }
                    }
                }
            } else {
                this.a.a(this.e.f());
            }
            super.a((Object) aqVar);
        }
    }
}
