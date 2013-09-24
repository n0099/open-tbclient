package com.baidu.tieba.person;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq extends BdAsyncTask<String, com.baidu.tieba.data.aq, com.baidu.tieba.data.aq> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1686a;
    private String b;
    private boolean c;
    private int d;
    private com.baidu.tieba.util.z e = null;
    private boolean f;

    public bq(PersonListActivity personListActivity, String str, boolean z, int i, boolean z2) {
        this.f1686a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = z2;
    }

    public bq(PersonListActivity personListActivity, String str, boolean z, int i) {
        this.f1686a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        br brVar;
        ProgressBar progressBar;
        br brVar2;
        br brVar3;
        if (this.e != null) {
            this.e.h();
        }
        brVar = this.f1686a.e;
        if (brVar != null) {
            brVar2 = this.f1686a.e;
            brVar2.b(false);
            brVar3 = this.f1686a.e;
            brVar3.notifyDataSetChanged();
        }
        progressBar = this.f1686a.d;
        progressBar.setVisibility(8);
        this.f1686a.g = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.aq a(String... strArr) {
        com.baidu.tieba.model.br brVar;
        com.baidu.tieba.model.br brVar2;
        com.baidu.tieba.model.br brVar3;
        com.baidu.tieba.model.br brVar4;
        this.e = new com.baidu.tieba.util.z();
        com.baidu.tieba.data.aq aqVar = null;
        if (this.f) {
            brVar3 = this.f1686a.j;
            if (brVar3 != null) {
                brVar4 = this.f1686a.j;
                c((Object[]) new com.baidu.tieba.data.aq[]{brVar4.b(this.c)});
            }
        }
        this.f = false;
        if (this.c) {
            this.e.a(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/u/follow/page");
        } else {
            this.e.a(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/u/fans/page");
        }
        if (this.b != null && !this.b.equals(TiebaApplication.C())) {
            this.e.a("uid", this.b);
        }
        if (this.d != 0) {
            this.e.a("pn", String.valueOf(this.d));
        }
        String j = this.e.j();
        if (this.e.c()) {
            aqVar = new com.baidu.tieba.data.aq();
            aqVar.a(j);
            if (aqVar.a().d() == 1) {
                brVar = this.f1686a.j;
                if (brVar != null) {
                    brVar2 = this.f1686a.j;
                    brVar2.a(j, this.c);
                }
            }
        }
        return aqVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(com.baidu.tieba.data.aq... aqVarArr) {
        ProgressBar progressBar;
        super.b((Object[]) aqVarArr);
        if (aqVarArr.length >= 1 && aqVarArr[0] != null) {
            com.baidu.tieba.data.aq aqVar = aqVarArr[0];
            ArrayList<UserData> b = aqVar.b();
            if (b != null && b.size() > 0) {
                a(aqVar, true);
            }
            progressBar = this.f1686a.d;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.aq aqVar) {
        ProgressBar progressBar;
        progressBar = this.f1686a.d;
        progressBar.setVisibility(8);
        this.f1686a.g = null;
        if (this.e != null) {
            if (this.e.c()) {
                a(aqVar, false);
            } else {
                this.f1686a.a(this.e.g());
            }
            super.a((bq) aqVar);
        }
    }

    private synchronized void a(com.baidu.tieba.data.aq aqVar, boolean z) {
        com.baidu.tieba.model.br brVar;
        com.baidu.tieba.data.aq aqVar2;
        com.baidu.tieba.model.br brVar2;
        brVar = this.f1686a.j;
        if (brVar != null && aqVar != null) {
            if (z) {
                aqVar2 = aqVar;
            } else {
                b(aqVar);
                brVar2 = this.f1686a.j;
                aqVar2 = brVar2.d();
            }
            d(aqVar2);
            if (!this.c) {
                com.baidu.tieba.mention.s.a().c(0L);
            }
            c(aqVar);
        }
    }

    private void b(com.baidu.tieba.data.aq aqVar) {
        com.baidu.tieba.model.br brVar;
        com.baidu.tieba.model.br brVar2;
        brVar = this.f1686a.j;
        brVar.d().b().addAll(aqVar.b());
        brVar2 = this.f1686a.j;
        brVar2.d().a(aqVar.a());
    }

    private void c(com.baidu.tieba.data.aq aqVar) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        com.baidu.tieba.model.br brVar;
        String string;
        int i;
        int i2;
        String string2;
        com.baidu.tieba.model.br brVar2;
        com.baidu.tieba.model.br brVar3;
        int i3;
        int i4;
        String string3;
        com.baidu.tieba.model.br brVar4;
        if (this.d == 0) {
            if (aqVar.a().c() > 0) {
                linearLayout2 = this.f1686a.c;
                linearLayout2.setVisibility(0);
                linearLayout3 = this.f1686a.c;
                TextView textView = (TextView) linearLayout3.findViewById(R.id.person_num);
                if (this.c) {
                    brVar3 = this.f1686a.j;
                    if (brVar3.a() != null) {
                        brVar4 = this.f1686a.j;
                        if (brVar4.a().equals(TiebaApplication.C())) {
                            string = this.f1686a.getString(R.string.my_attention_prefix);
                            string2 = this.f1686a.getString(R.string.person);
                        }
                    }
                    i3 = this.f1686a.n;
                    if (i3 != 2) {
                        i4 = this.f1686a.n;
                        if (i4 == 1) {
                            string3 = this.f1686a.getString(R.string.he_attention_prefix);
                        } else {
                            string3 = this.f1686a.getString(R.string.its_attention_prefix);
                        }
                    } else {
                        string3 = this.f1686a.getString(R.string.she_attention_prefix);
                    }
                    string = string3;
                    string2 = this.f1686a.getString(R.string.person);
                } else {
                    brVar = this.f1686a.j;
                    if (brVar.a() != null) {
                        brVar2 = this.f1686a.j;
                        if (brVar2.a().equals(TiebaApplication.C())) {
                            string = this.f1686a.getString(R.string.my_fans_prefix);
                            string2 = this.f1686a.getString(R.string.my_fans_suffix);
                        }
                    }
                    string = this.f1686a.getString(R.string.its_fans_prefix);
                    i = this.f1686a.n;
                    if (i != 2) {
                        i2 = this.f1686a.n;
                        if (i2 == 1) {
                            string2 = this.f1686a.getString(R.string.his_fans_suffix);
                        } else {
                            string2 = this.f1686a.getString(R.string.its_fans_suffix);
                        }
                    } else {
                        string2 = this.f1686a.getString(R.string.her_fans_suffix);
                    }
                }
                textView.setText(String.valueOf(string) + String.valueOf(aqVar.a().c()) + string2);
                return;
            }
            linearLayout = this.f1686a.c;
            linearLayout.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.data.aq aqVar) {
        br brVar;
        br brVar2;
        br brVar3;
        br brVar4;
        br brVar5;
        br brVar6;
        boolean z = true;
        brVar = this.f1686a.e;
        if (brVar != null && aqVar != null) {
            com.baidu.tieba.data.an a2 = aqVar.a();
            brVar2 = this.f1686a.e;
            if (a2 == null || a2.f() != 1) {
                z = false;
            }
            brVar2.a(z);
            brVar3 = this.f1686a.e;
            brVar3.a(aqVar.b());
            brVar4 = this.f1686a.e;
            brVar4.b(false);
            brVar5 = this.f1686a.e;
            brVar5.b();
            brVar6 = this.f1686a.e;
            brVar6.notifyDataSetChanged();
        }
    }
}
