package com.baidu.tieba.person;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class df extends BdAsyncTask<String, com.baidu.tieba.data.ao, com.baidu.tieba.data.ao> {
    final /* synthetic */ PersonListActivity a;
    private final String b;
    private final boolean c;
    private final int d;
    private com.baidu.tieba.util.ba e = null;
    private boolean f;

    public df(PersonListActivity personListActivity, String str, boolean z, int i, boolean z2) {
        this.a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = z2;
    }

    public df(PersonListActivity personListActivity, String str, boolean z, int i) {
        this.a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        dg dgVar;
        ProgressBar progressBar;
        dg dgVar2;
        dg dgVar3;
        if (this.e != null) {
            this.e.k();
        }
        dgVar = this.a.g;
        if (dgVar != null) {
            dgVar2 = this.a.g;
            dgVar2.b(false);
            dgVar3 = this.a.g;
            dgVar3.notifyDataSetChanged();
        }
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        this.a.i = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.ao a(String... strArr) {
        com.baidu.tieba.model.br brVar;
        com.baidu.tieba.model.br brVar2;
        com.baidu.tieba.model.br brVar3;
        com.baidu.tieba.model.br brVar4;
        this.e = new com.baidu.tieba.util.ba();
        com.baidu.tieba.data.ao aoVar = null;
        if (this.f) {
            brVar3 = this.a.j;
            if (brVar3 != null) {
                brVar4 = this.a.j;
                c((Object[]) new com.baidu.tieba.data.ao[]{brVar4.b(this.c)});
            }
        }
        this.f = false;
        if (this.c) {
            this.e.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/u/follow/page");
        } else {
            this.e.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/u/fans/page");
        }
        if (this.b != null && !this.b.equals(TiebaApplication.A())) {
            this.e.a(SapiAccountManager.SESSION_UID, this.b);
        }
        if (this.d != 0) {
            this.e.a("pn", String.valueOf(this.d));
        }
        String m = this.e.m();
        if (this.e.d()) {
            aoVar = new com.baidu.tieba.data.ao();
            aoVar.a(m);
            if (aoVar.a().d() == 1) {
                brVar = this.a.j;
                if (brVar != null) {
                    brVar2 = this.a.j;
                    brVar2.a(m, this.c);
                }
            }
        }
        return aoVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(com.baidu.tieba.data.ao... aoVarArr) {
        ProgressBar progressBar;
        ArrayList<UserData> b;
        super.b((Object[]) aoVarArr);
        if (aoVarArr.length >= 1) {
            com.baidu.tieba.data.ao aoVar = aoVarArr[0];
            if (aoVar != null && (b = aoVar.b()) != null && b.size() > 0) {
                a(aoVar, true);
            }
            progressBar = this.a.f;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ao aoVar) {
        ProgressBar progressBar;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        this.a.i = null;
        if (this.e != null) {
            if (this.e.d()) {
                a(aoVar, false);
            } else {
                a(aoVar, true);
                this.a.showToast(this.e.j());
            }
            super.a((df) aoVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
        if (r0.b().size() > 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void a(com.baidu.tieba.data.ao aoVar, boolean z) {
        com.baidu.tieba.model.br brVar;
        com.baidu.tieba.data.ao aoVar2;
        com.baidu.tieba.data.ao aoVar3;
        com.baidu.tieba.data.ao aoVar4;
        com.baidu.tieba.data.ao aoVar5;
        com.baidu.tieba.data.ao aoVar6;
        com.baidu.tieba.model.br brVar2;
        brVar = this.a.j;
        if (brVar != null) {
            if (aoVar == null) {
                aoVar2 = this.a.q;
                if (aoVar2 != null) {
                    aoVar4 = this.a.q;
                    if (aoVar4.b() != null) {
                        aoVar5 = this.a.q;
                    }
                }
                aoVar3 = this.a.q;
                d(aoVar3);
            } else {
                if (z) {
                    aoVar6 = aoVar;
                } else {
                    b(aoVar);
                    brVar2 = this.a.j;
                    aoVar6 = brVar2.d();
                }
                this.a.q = aoVar6;
                d(aoVar6);
                if (!this.c) {
                    com.baidu.tieba.mention.v.a().d(0);
                }
                c(aoVar);
            }
        }
    }

    private void b(com.baidu.tieba.data.ao aoVar) {
        com.baidu.tieba.model.br brVar;
        com.baidu.tieba.model.br brVar2;
        brVar = this.a.j;
        brVar.d().b().addAll(aoVar.b());
        brVar2 = this.a.j;
        brVar2.d().a(aoVar.a());
    }

    private void c(com.baidu.tieba.data.ao aoVar) {
        View view;
        BdListView bdListView;
        LinearLayout linearLayout;
        com.baidu.tieba.model.br brVar;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        com.baidu.tieba.model.br brVar2;
        TextView textView4;
        com.baidu.tieba.model.br brVar3;
        int i3;
        int i4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        com.baidu.tieba.model.br brVar4;
        TextView textView8;
        View view2;
        BdListView bdListView2;
        LinearLayout linearLayout2;
        com.baidu.tieba.model.br brVar5;
        String string;
        int i5;
        int i6;
        String string2;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        com.baidu.tieba.model.br brVar6;
        TextView textView12;
        TextView textView13;
        com.baidu.tieba.model.br brVar7;
        int i7;
        int i8;
        String string3;
        TextView textView14;
        TextView textView15;
        TextView textView16;
        com.baidu.tieba.model.br brVar8;
        TextView textView17;
        if (this.d == 0) {
            if (aoVar.a().c() > 0) {
                view2 = this.a.c;
                view2.setVisibility(0);
                bdListView2 = this.a.b;
                bdListView2.setVisibility(0);
                linearLayout2 = this.a.k;
                linearLayout2.setVisibility(8);
                if (this.c) {
                    brVar7 = this.a.j;
                    if (brVar7.a() != null) {
                        brVar8 = this.a.j;
                        if (brVar8.a().equals(TiebaApplication.A())) {
                            string = this.a.getString(R.string.my_attention_prefix);
                            string2 = this.a.getString(R.string.person);
                            textView17 = this.a.l;
                            textView17.setText(R.string.not_have_attention);
                        }
                    }
                    i7 = this.a.p;
                    if (i7 != 2) {
                        i8 = this.a.p;
                        if (i8 == 1) {
                            string3 = this.a.getString(R.string.he_attention_prefix);
                            textView15 = this.a.l;
                            textView15.setText(R.string.him_no_attention_other);
                        } else {
                            string3 = this.a.getString(R.string.its_attention_prefix);
                            textView14 = this.a.l;
                            textView14.setText(R.string.no_attention_other);
                        }
                    } else {
                        string3 = this.a.getString(R.string.she_attention_prefix);
                        textView16 = this.a.l;
                        textView16.setText(R.string.her_no_attention_other);
                    }
                    string = string3;
                    string2 = this.a.getString(R.string.person);
                } else {
                    brVar5 = this.a.j;
                    if (brVar5.a() != null) {
                        brVar6 = this.a.j;
                        if (brVar6.a().equals(TiebaApplication.A())) {
                            string = this.a.getString(R.string.my_fans_prefix);
                            string2 = this.a.getString(R.string.my_fans_suffix);
                            textView12 = this.a.l;
                            textView12.setText(R.string.not_have_fans);
                        }
                    }
                    string = this.a.getString(R.string.its_fans_prefix);
                    i5 = this.a.p;
                    if (i5 != 2) {
                        i6 = this.a.p;
                        if (i6 == 1) {
                            string2 = this.a.getString(R.string.his_fans_suffix);
                            textView10 = this.a.l;
                            textView10.setText(R.string.him_no_fan_other);
                        } else {
                            string2 = this.a.getString(R.string.its_fans_suffix);
                            textView9 = this.a.l;
                            textView9.setText(R.string.no_fan_other);
                        }
                    } else {
                        string2 = this.a.getString(R.string.her_fans_suffix);
                        textView11 = this.a.l;
                        textView11.setText(R.string.her_no_fan_other);
                    }
                }
                textView13 = this.a.e;
                textView13.setText(String.valueOf(string) + String.valueOf(aoVar.a().c()) + string2);
                return;
            }
            view = this.a.c;
            view.setVisibility(8);
            bdListView = this.a.b;
            bdListView.setVisibility(8);
            linearLayout = this.a.k;
            linearLayout.setVisibility(0);
            if (this.c) {
                brVar3 = this.a.j;
                if (brVar3.a() != null) {
                    brVar4 = this.a.j;
                    if (brVar4.a().equals(TiebaApplication.A())) {
                        textView8 = this.a.l;
                        textView8.setText(R.string.not_have_attention);
                        return;
                    }
                }
                i3 = this.a.p;
                if (i3 == 2) {
                    textView7 = this.a.l;
                    textView7.setText(R.string.her_no_attention_other);
                    return;
                }
                i4 = this.a.p;
                if (i4 == 1) {
                    textView6 = this.a.l;
                    textView6.setText(R.string.him_no_attention_other);
                    return;
                }
                textView5 = this.a.l;
                textView5.setText(R.string.no_attention_other);
                return;
            }
            brVar = this.a.j;
            if (brVar.a() != null) {
                brVar2 = this.a.j;
                if (brVar2.a().equals(TiebaApplication.A())) {
                    textView4 = this.a.l;
                    textView4.setText(R.string.not_have_fans);
                    return;
                }
            }
            i = this.a.p;
            if (i == 2) {
                textView3 = this.a.l;
                textView3.setText(R.string.her_no_fan_other);
                return;
            }
            i2 = this.a.p;
            if (i2 == 1) {
                textView2 = this.a.l;
                textView2.setText(R.string.him_no_fan_other);
                return;
            }
            textView = this.a.l;
            textView.setText(R.string.no_fan_other);
        }
    }

    private void d(com.baidu.tieba.data.ao aoVar) {
        dg dgVar;
        dg dgVar2;
        dg dgVar3;
        dg dgVar4;
        dg dgVar5;
        dg dgVar6;
        dg dgVar7;
        dg dgVar8;
        dg dgVar9;
        dg dgVar10;
        dg dgVar11;
        boolean z = true;
        dgVar = this.a.g;
        if (dgVar != null) {
            if (aoVar == null) {
                dgVar2 = this.a.g;
                dgVar2.a(false);
                dgVar3 = this.a.g;
                dgVar3.a(new ArrayList<>());
                dgVar4 = this.a.g;
                dgVar4.b(false);
                dgVar5 = this.a.g;
                dgVar5.b();
                dgVar6 = this.a.g;
                dgVar6.notifyDataSetChanged();
                return;
            }
            com.baidu.tieba.data.al a = aoVar.a();
            dgVar7 = this.a.g;
            if (a == null || a.f() != 1) {
                z = false;
            }
            dgVar7.a(z);
            dgVar8 = this.a.g;
            dgVar8.a(aoVar.b());
            dgVar9 = this.a.g;
            dgVar9.b(false);
            dgVar10 = this.a.g;
            dgVar10.b();
            dgVar11 = this.a.g;
            dgVar11.notifyDataSetChanged();
        }
    }
}
