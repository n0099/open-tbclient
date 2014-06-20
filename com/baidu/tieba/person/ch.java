package com.baidu.tieba.person;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch extends BdAsyncTask<String, com.baidu.tieba.data.ah, com.baidu.tieba.data.ah> {
    final /* synthetic */ PersonListActivity a;
    private final String b;
    private final boolean c;
    private final int d;
    private com.baidu.tbadk.core.util.an e = null;
    private boolean f;

    public ch(PersonListActivity personListActivity, String str, boolean z, int i, boolean z2) {
        this.a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = z2;
    }

    public ch(PersonListActivity personListActivity, String str, boolean z, int i) {
        this.a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ci ciVar;
        ProgressBar progressBar;
        ci ciVar2;
        ci ciVar3;
        if (this.e != null) {
            this.e.g();
        }
        ciVar = this.a.g;
        if (ciVar != null) {
            ciVar2 = this.a.g;
            ciVar2.b(false);
            ciVar3 = this.a.g;
            ciVar3.notifyDataSetChanged();
        }
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        this.a.i = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tieba.data.ah doInBackground(String... strArr) {
        com.baidu.tieba.model.ay ayVar;
        com.baidu.tieba.model.ay ayVar2;
        com.baidu.tieba.model.ay ayVar3;
        com.baidu.tieba.model.ay ayVar4;
        this.e = new com.baidu.tbadk.core.util.an();
        com.baidu.tieba.data.ah ahVar = null;
        if (this.f) {
            ayVar3 = this.a.j;
            if (ayVar3 != null) {
                ayVar4 = this.a.j;
                publishProgress(ayVar4.b(this.c));
            }
        }
        this.f = false;
        if (this.c) {
            this.e.a(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page");
        } else {
            this.e.a(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page");
        }
        if (this.b != null && !this.b.equals(TbadkApplication.getCurrentAccount())) {
            this.e.a(SapiAccountManager.SESSION_UID, this.b);
        }
        if (this.d != 0) {
            this.e.a("pn", String.valueOf(this.d));
        }
        String i = this.e.i();
        if (this.e.a().b().b()) {
            ahVar = new com.baidu.tieba.data.ah();
            ahVar.a(i);
            if (ahVar.a().d() == 1) {
                ayVar = this.a.j;
                if (ayVar != null) {
                    ayVar2 = this.a.j;
                    ayVar2.a(i, this.c);
                }
            }
        }
        return ahVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(com.baidu.tieba.data.ah... ahVarArr) {
        ProgressBar progressBar;
        ArrayList<UserData> b;
        super.onProgressUpdate(ahVarArr);
        if (ahVarArr.length >= 1) {
            com.baidu.tieba.data.ah ahVar = ahVarArr[0];
            if (ahVar != null && (b = ahVar.b()) != null && b.size() > 0) {
                a(ahVar, true);
            }
            progressBar = this.a.f;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.ah ahVar) {
        ProgressBar progressBar;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        this.a.i = null;
        if (this.e != null) {
            if (this.e.a().b().b()) {
                a(ahVar, false);
            } else {
                a(ahVar, true);
                this.a.showToast(this.e.f());
            }
            super.onPostExecute(ahVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
        if (r0.b().size() > 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void a(com.baidu.tieba.data.ah ahVar, boolean z) {
        com.baidu.tieba.model.ay ayVar;
        com.baidu.tieba.data.ah ahVar2;
        com.baidu.tieba.data.ah ahVar3;
        com.baidu.tieba.data.ah ahVar4;
        com.baidu.tieba.data.ah ahVar5;
        com.baidu.tieba.data.ah ahVar6;
        com.baidu.tieba.model.ay ayVar2;
        ayVar = this.a.j;
        if (ayVar != null) {
            if (ahVar == null) {
                ahVar2 = this.a.q;
                if (ahVar2 != null) {
                    ahVar4 = this.a.q;
                    if (ahVar4.b() != null) {
                        ahVar5 = this.a.q;
                    }
                }
                ahVar3 = this.a.q;
                d(ahVar3);
            } else {
                if (z) {
                    ahVar6 = ahVar;
                } else {
                    b(ahVar);
                    ayVar2 = this.a.j;
                    ahVar6 = ayVar2.d();
                }
                this.a.q = ahVar6;
                d(ahVar6);
                if (!this.c) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.a().d(0);
                }
                c(ahVar);
            }
        }
    }

    private void b(com.baidu.tieba.data.ah ahVar) {
        com.baidu.tieba.model.ay ayVar;
        com.baidu.tieba.model.ay ayVar2;
        ayVar = this.a.j;
        ayVar.d().b().addAll(ahVar.b());
        ayVar2 = this.a.j;
        ayVar2.d().a(ahVar.a());
    }

    private void c(com.baidu.tieba.data.ah ahVar) {
        View view;
        BdListView bdListView;
        LinearLayout linearLayout;
        com.baidu.tieba.model.ay ayVar;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        com.baidu.tieba.model.ay ayVar2;
        TextView textView4;
        com.baidu.tieba.model.ay ayVar3;
        int i3;
        int i4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        com.baidu.tieba.model.ay ayVar4;
        TextView textView8;
        View view2;
        BdListView bdListView2;
        LinearLayout linearLayout2;
        com.baidu.tieba.model.ay ayVar5;
        String string;
        int i5;
        int i6;
        String string2;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        com.baidu.tieba.model.ay ayVar6;
        TextView textView12;
        TextView textView13;
        com.baidu.tieba.model.ay ayVar7;
        int i7;
        int i8;
        String string3;
        TextView textView14;
        TextView textView15;
        TextView textView16;
        com.baidu.tieba.model.ay ayVar8;
        TextView textView17;
        if (this.d == 0) {
            if (ahVar.a().c() > 0) {
                view2 = this.a.c;
                view2.setVisibility(0);
                bdListView2 = this.a.b;
                bdListView2.setVisibility(0);
                linearLayout2 = this.a.k;
                linearLayout2.setVisibility(8);
                if (this.c) {
                    ayVar7 = this.a.j;
                    if (ayVar7.a() != null) {
                        ayVar8 = this.a.j;
                        if (ayVar8.a().equals(TbadkApplication.getCurrentAccount())) {
                            string = this.a.getString(com.baidu.tieba.y.my_attention_prefix);
                            string2 = this.a.getString(com.baidu.tieba.y.person);
                            textView17 = this.a.l;
                            textView17.setText(com.baidu.tieba.y.not_have_attention);
                        }
                    }
                    i7 = this.a.p;
                    if (i7 != 2) {
                        i8 = this.a.p;
                        if (i8 == 1) {
                            string3 = this.a.getString(com.baidu.tieba.y.he_attention_prefix);
                            textView15 = this.a.l;
                            textView15.setText(com.baidu.tieba.y.him_no_attention_other);
                        } else {
                            string3 = this.a.getString(com.baidu.tieba.y.its_attention_prefix);
                            textView14 = this.a.l;
                            textView14.setText(com.baidu.tieba.y.no_attention_other);
                        }
                    } else {
                        string3 = this.a.getString(com.baidu.tieba.y.she_attention_prefix);
                        textView16 = this.a.l;
                        textView16.setText(com.baidu.tieba.y.her_no_attention_other);
                    }
                    string = string3;
                    string2 = this.a.getString(com.baidu.tieba.y.person);
                } else {
                    ayVar5 = this.a.j;
                    if (ayVar5.a() != null) {
                        ayVar6 = this.a.j;
                        if (ayVar6.a().equals(TbadkApplication.getCurrentAccount())) {
                            string = this.a.getString(com.baidu.tieba.y.my_fans_prefix);
                            string2 = this.a.getString(com.baidu.tieba.y.my_fans_suffix);
                            textView12 = this.a.l;
                            textView12.setText(com.baidu.tieba.y.not_have_fans);
                        }
                    }
                    string = this.a.getString(com.baidu.tieba.y.its_fans_prefix);
                    i5 = this.a.p;
                    if (i5 != 2) {
                        i6 = this.a.p;
                        if (i6 == 1) {
                            string2 = this.a.getString(com.baidu.tieba.y.his_fans_suffix);
                            textView10 = this.a.l;
                            textView10.setText(com.baidu.tieba.y.him_no_fan_other);
                        } else {
                            string2 = this.a.getString(com.baidu.tieba.y.its_fans_suffix);
                            textView9 = this.a.l;
                            textView9.setText(com.baidu.tieba.y.no_fan_other);
                        }
                    } else {
                        string2 = this.a.getString(com.baidu.tieba.y.her_fans_suffix);
                        textView11 = this.a.l;
                        textView11.setText(com.baidu.tieba.y.her_no_fan_other);
                    }
                }
                textView13 = this.a.e;
                textView13.setText(String.valueOf(string) + String.valueOf(ahVar.a().c()) + string2);
                return;
            }
            view = this.a.c;
            view.setVisibility(8);
            bdListView = this.a.b;
            bdListView.setVisibility(8);
            linearLayout = this.a.k;
            linearLayout.setVisibility(0);
            if (this.c) {
                ayVar3 = this.a.j;
                if (ayVar3.a() != null) {
                    ayVar4 = this.a.j;
                    if (ayVar4.a().equals(TbadkApplication.getCurrentAccount())) {
                        textView8 = this.a.l;
                        textView8.setText(com.baidu.tieba.y.not_have_attention);
                        return;
                    }
                }
                i3 = this.a.p;
                if (i3 == 2) {
                    textView7 = this.a.l;
                    textView7.setText(com.baidu.tieba.y.her_no_attention_other);
                    return;
                }
                i4 = this.a.p;
                if (i4 == 1) {
                    textView6 = this.a.l;
                    textView6.setText(com.baidu.tieba.y.him_no_attention_other);
                    return;
                }
                textView5 = this.a.l;
                textView5.setText(com.baidu.tieba.y.no_attention_other);
                return;
            }
            ayVar = this.a.j;
            if (ayVar.a() != null) {
                ayVar2 = this.a.j;
                if (ayVar2.a().equals(TbadkApplication.getCurrentAccount())) {
                    textView4 = this.a.l;
                    textView4.setText(com.baidu.tieba.y.not_have_fans);
                    return;
                }
            }
            i = this.a.p;
            if (i == 2) {
                textView3 = this.a.l;
                textView3.setText(com.baidu.tieba.y.her_no_fan_other);
                return;
            }
            i2 = this.a.p;
            if (i2 == 1) {
                textView2 = this.a.l;
                textView2.setText(com.baidu.tieba.y.him_no_fan_other);
                return;
            }
            textView = this.a.l;
            textView.setText(com.baidu.tieba.y.no_fan_other);
        }
    }

    private void d(com.baidu.tieba.data.ah ahVar) {
        ci ciVar;
        ci ciVar2;
        ci ciVar3;
        ci ciVar4;
        ci ciVar5;
        ci ciVar6;
        ci ciVar7;
        ci ciVar8;
        ci ciVar9;
        ci ciVar10;
        ci ciVar11;
        boolean z = true;
        ciVar = this.a.g;
        if (ciVar != null) {
            if (ahVar == null) {
                ciVar2 = this.a.g;
                ciVar2.a(false);
                ciVar3 = this.a.g;
                ciVar3.a(new ArrayList<>());
                ciVar4 = this.a.g;
                ciVar4.b(false);
                ciVar5 = this.a.g;
                ciVar5.b();
                ciVar6 = this.a.g;
                ciVar6.notifyDataSetChanged();
                return;
            }
            com.baidu.tbadk.core.data.l a = ahVar.a();
            ciVar7 = this.a.g;
            if (a == null || a.f() != 1) {
                z = false;
            }
            ciVar7.a(z);
            ciVar8 = this.a.g;
            ciVar8.a(ahVar.b());
            ciVar9 = this.a.g;
            ciVar9.b(false);
            ciVar10 = this.a.g;
            ciVar10.b();
            ciVar11 = this.a.g;
            ciVar11.notifyDataSetChanged();
        }
    }
}
