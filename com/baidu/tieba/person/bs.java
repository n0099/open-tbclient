package com.baidu.tieba.person;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1638a;
    private String b;
    private boolean c;
    private int d;
    private com.baidu.tieba.util.v e = null;
    private boolean f;

    public bs(PersonListActivity personListActivity, String str, boolean z, int i, boolean z2) {
        this.f1638a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = z2;
    }

    public bs(PersonListActivity personListActivity, String str, boolean z, int i) {
        this.f1638a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bt btVar;
        ProgressBar progressBar;
        bt btVar2;
        bt btVar3;
        if (this.e != null) {
            this.e.h();
        }
        btVar = this.f1638a.f;
        if (btVar != null) {
            btVar2 = this.f1638a.f;
            btVar2.b(false);
            btVar3 = this.f1638a.f;
            btVar3.notifyDataSetChanged();
        }
        progressBar = this.f1638a.e;
        progressBar.setVisibility(8);
        this.f1638a.j = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.aq a(String... strArr) {
        com.baidu.tieba.model.bp bpVar;
        com.baidu.tieba.model.bp bpVar2;
        com.baidu.tieba.model.bp bpVar3;
        com.baidu.tieba.model.bp bpVar4;
        this.e = new com.baidu.tieba.util.v();
        com.baidu.tieba.data.aq aqVar = null;
        if (this.f) {
            bpVar3 = this.f1638a.k;
            if (bpVar3 != null) {
                bpVar4 = this.f1638a.k;
                c((Object[]) new com.baidu.tieba.data.aq[]{bpVar4.b(this.c)});
            }
        }
        this.f = false;
        if (this.c) {
            this.e.a(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/u/follow/page");
        } else {
            this.e.a(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/u/fans/page");
        }
        if (this.b != null && !this.b.equals(TiebaApplication.E())) {
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
                bpVar = this.f1638a.k;
                if (bpVar != null) {
                    bpVar2 = this.f1638a.k;
                    bpVar2.a(j, this.c);
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
            ArrayList b = aqVar.b();
            if (b != null && b.size() > 0) {
                a(aqVar, true);
            }
            progressBar = this.f1638a.e;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.aq aqVar) {
        ProgressBar progressBar;
        progressBar = this.f1638a.e;
        progressBar.setVisibility(8);
        this.f1638a.j = null;
        if (this.e != null) {
            if (this.e.c()) {
                a(aqVar, false);
            } else {
                this.f1638a.a(this.e.g());
            }
            super.a((Object) aqVar);
        }
    }

    private synchronized void a(com.baidu.tieba.data.aq aqVar, boolean z) {
        com.baidu.tieba.model.bp bpVar;
        com.baidu.tieba.data.aq aqVar2;
        com.baidu.tieba.model.bp bpVar2;
        bpVar = this.f1638a.k;
        if (bpVar != null && aqVar != null) {
            if (z) {
                aqVar2 = aqVar;
            } else {
                b(aqVar);
                bpVar2 = this.f1638a.k;
                aqVar2 = bpVar2.d();
            }
            d(aqVar2);
            if (!this.c) {
                com.baidu.tieba.mention.r.a().c(0L);
            }
            c(aqVar);
        }
    }

    private void b(com.baidu.tieba.data.aq aqVar) {
        com.baidu.tieba.model.bp bpVar;
        com.baidu.tieba.model.bp bpVar2;
        bpVar = this.f1638a.k;
        bpVar.d().b().addAll(aqVar.b());
        bpVar2 = this.f1638a.k;
        bpVar2.d().a(aqVar.a());
    }

    private void c(com.baidu.tieba.data.aq aqVar) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        com.baidu.tieba.model.bp bpVar;
        String string;
        int i;
        int i2;
        String string2;
        com.baidu.tieba.model.bp bpVar2;
        com.baidu.tieba.model.bp bpVar3;
        int i3;
        int i4;
        String string3;
        com.baidu.tieba.model.bp bpVar4;
        if (this.d == 0) {
            if (aqVar.a().c() > 0) {
                linearLayout2 = this.f1638a.d;
                linearLayout2.setVisibility(0);
                linearLayout3 = this.f1638a.d;
                TextView textView = (TextView) linearLayout3.findViewById(R.id.person_num);
                if (this.c) {
                    bpVar3 = this.f1638a.k;
                    if (bpVar3.a() != null) {
                        bpVar4 = this.f1638a.k;
                        if (bpVar4.a().equals(TiebaApplication.E())) {
                            string = this.f1638a.getString(R.string.my_attention_prefix);
                            string2 = this.f1638a.getString(R.string.person);
                        }
                    }
                    i3 = this.f1638a.o;
                    if (i3 != 2) {
                        i4 = this.f1638a.o;
                        if (i4 == 1) {
                            string3 = this.f1638a.getString(R.string.he_attention_prefix);
                        } else {
                            string3 = this.f1638a.getString(R.string.its_attention_prefix);
                        }
                    } else {
                        string3 = this.f1638a.getString(R.string.she_attention_prefix);
                    }
                    string = string3;
                    string2 = this.f1638a.getString(R.string.person);
                } else {
                    bpVar = this.f1638a.k;
                    if (bpVar.a() != null) {
                        bpVar2 = this.f1638a.k;
                        if (bpVar2.a().equals(TiebaApplication.E())) {
                            string = this.f1638a.getString(R.string.my_fans_prefix);
                            string2 = this.f1638a.getString(R.string.my_fans_suffix);
                        }
                    }
                    string = this.f1638a.getString(R.string.its_fans_prefix);
                    i = this.f1638a.o;
                    if (i != 2) {
                        i2 = this.f1638a.o;
                        if (i2 == 1) {
                            string2 = this.f1638a.getString(R.string.his_fans_suffix);
                        } else {
                            string2 = this.f1638a.getString(R.string.its_fans_suffix);
                        }
                    } else {
                        string2 = this.f1638a.getString(R.string.her_fans_suffix);
                    }
                }
                textView.setText(String.valueOf(string) + String.valueOf(aqVar.a().c()) + string2);
                return;
            }
            linearLayout = this.f1638a.d;
            linearLayout.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.data.aq aqVar) {
        bt btVar;
        bt btVar2;
        bt btVar3;
        bt btVar4;
        bt btVar5;
        bt btVar6;
        boolean z = true;
        btVar = this.f1638a.f;
        if (btVar != null && aqVar != null) {
            com.baidu.tieba.data.an a2 = aqVar.a();
            btVar2 = this.f1638a.f;
            if (a2 == null || a2.f() != 1) {
                z = false;
            }
            btVar2.a(z);
            btVar3 = this.f1638a.f;
            btVar3.a(aqVar.b());
            btVar4 = this.f1638a.f;
            btVar4.b(false);
            btVar5 = this.f1638a.f;
            btVar5.b();
            btVar6 = this.f1638a.f;
            btVar6.notifyDataSetChanged();
        }
    }
}
