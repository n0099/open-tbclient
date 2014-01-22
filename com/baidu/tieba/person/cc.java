package com.baidu.tieba.person;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc extends BdAsyncTask<String, com.baidu.tieba.data.aq, com.baidu.tieba.data.aq> {
    final /* synthetic */ PersonListActivity a;
    private String b;
    private boolean c;
    private int d;
    private com.baidu.tieba.util.ax e = null;
    private boolean f;

    public cc(PersonListActivity personListActivity, String str, boolean z, int i, boolean z2) {
        this.a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = z2;
    }

    public cc(PersonListActivity personListActivity, String str, boolean z, int i) {
        this.a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        cd cdVar;
        ProgressBar progressBar;
        cd cdVar2;
        cd cdVar3;
        if (this.e != null) {
            this.e.k();
        }
        cdVar = this.a.e;
        if (cdVar != null) {
            cdVar2 = this.a.e;
            cdVar2.b(false);
            cdVar3 = this.a.e;
            cdVar3.notifyDataSetChanged();
        }
        progressBar = this.a.d;
        progressBar.setVisibility(8);
        this.a.g = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.aq a(String... strArr) {
        com.baidu.tieba.model.ca caVar;
        com.baidu.tieba.model.ca caVar2;
        com.baidu.tieba.model.ca caVar3;
        com.baidu.tieba.model.ca caVar4;
        this.e = new com.baidu.tieba.util.ax();
        com.baidu.tieba.data.aq aqVar = null;
        if (this.f) {
            caVar3 = this.a.h;
            if (caVar3 != null) {
                caVar4 = this.a.h;
                c((Object[]) new com.baidu.tieba.data.aq[]{caVar4.b(this.c)});
            }
        }
        this.f = false;
        if (this.c) {
            this.e.a(com.baidu.tieba.data.h.a + "c/u/follow/page");
        } else {
            this.e.a(com.baidu.tieba.data.h.a + "c/u/fans/page");
        }
        if (this.b != null && !this.b.equals(TiebaApplication.A())) {
            this.e.a(SapiAccountManager.SESSION_UID, this.b);
        }
        if (this.d != 0) {
            this.e.a("pn", String.valueOf(this.d));
        }
        String m = this.e.m();
        if (this.e.d()) {
            aqVar = new com.baidu.tieba.data.aq();
            aqVar.a(m);
            if (aqVar.a().d() == 1) {
                caVar = this.a.h;
                if (caVar != null) {
                    caVar2 = this.a.h;
                    caVar2.a(m, this.c);
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
        ArrayList<UserData> b;
        super.b((Object[]) aqVarArr);
        if (aqVarArr.length >= 1) {
            com.baidu.tieba.data.aq aqVar = aqVarArr[0];
            if (aqVar != null && (b = aqVar.b()) != null && b.size() > 0) {
                a(aqVar, true);
            }
            progressBar = this.a.d;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.aq aqVar) {
        ProgressBar progressBar;
        progressBar = this.a.d;
        progressBar.setVisibility(8);
        this.a.g = null;
        if (this.e != null) {
            if (this.e.d()) {
                a(aqVar, false);
            } else {
                a(aqVar, true);
                this.a.showToast(this.e.j());
            }
            super.a((cc) aqVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
        if (r0.b().size() > 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void a(com.baidu.tieba.data.aq aqVar, boolean z) {
        com.baidu.tieba.model.ca caVar;
        com.baidu.tieba.data.aq aqVar2;
        com.baidu.tieba.data.aq aqVar3;
        com.baidu.tieba.data.aq aqVar4;
        com.baidu.tieba.data.aq aqVar5;
        com.baidu.tieba.data.aq aqVar6;
        com.baidu.tieba.model.ca caVar2;
        caVar = this.a.h;
        if (caVar != null) {
            if (aqVar == null) {
                aqVar2 = this.a.m;
                if (aqVar2 != null) {
                    aqVar4 = this.a.m;
                    if (aqVar4.b() != null) {
                        aqVar5 = this.a.m;
                    }
                }
                aqVar3 = this.a.m;
                d(aqVar3);
            } else {
                if (z) {
                    aqVar6 = aqVar;
                } else {
                    b(aqVar);
                    caVar2 = this.a.h;
                    aqVar6 = caVar2.d();
                }
                this.a.m = aqVar6;
                d(aqVar6);
                if (!this.c) {
                    com.baidu.tieba.mention.s.a().d(0);
                }
                c(aqVar);
            }
        }
    }

    private void b(com.baidu.tieba.data.aq aqVar) {
        com.baidu.tieba.model.ca caVar;
        com.baidu.tieba.model.ca caVar2;
        caVar = this.a.h;
        caVar.d().b().addAll(aqVar.b());
        caVar2 = this.a.h;
        caVar2.d().a(aqVar.a());
    }

    private void c(com.baidu.tieba.data.aq aqVar) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        com.baidu.tieba.model.ca caVar;
        String string;
        int i;
        int i2;
        String string2;
        com.baidu.tieba.model.ca caVar2;
        com.baidu.tieba.model.ca caVar3;
        int i3;
        int i4;
        String string3;
        com.baidu.tieba.model.ca caVar4;
        if (this.d == 0) {
            if (aqVar.a().c() > 0) {
                linearLayout2 = this.a.c;
                linearLayout2.setVisibility(0);
                linearLayout3 = this.a.c;
                TextView textView = (TextView) linearLayout3.findViewById(R.id.person_num);
                if (this.c) {
                    caVar3 = this.a.h;
                    if (caVar3.a() != null) {
                        caVar4 = this.a.h;
                        if (caVar4.a().equals(TiebaApplication.A())) {
                            string = this.a.getString(R.string.my_attention_prefix);
                            string2 = this.a.getString(R.string.person);
                        }
                    }
                    i3 = this.a.l;
                    if (i3 != 2) {
                        i4 = this.a.l;
                        if (i4 == 1) {
                            string3 = this.a.getString(R.string.he_attention_prefix);
                        } else {
                            string3 = this.a.getString(R.string.its_attention_prefix);
                        }
                    } else {
                        string3 = this.a.getString(R.string.she_attention_prefix);
                    }
                    string = string3;
                    string2 = this.a.getString(R.string.person);
                } else {
                    caVar = this.a.h;
                    if (caVar.a() != null) {
                        caVar2 = this.a.h;
                        if (caVar2.a().equals(TiebaApplication.A())) {
                            string = this.a.getString(R.string.my_fans_prefix);
                            string2 = this.a.getString(R.string.my_fans_suffix);
                        }
                    }
                    string = this.a.getString(R.string.its_fans_prefix);
                    i = this.a.l;
                    if (i != 2) {
                        i2 = this.a.l;
                        if (i2 == 1) {
                            string2 = this.a.getString(R.string.his_fans_suffix);
                        } else {
                            string2 = this.a.getString(R.string.its_fans_suffix);
                        }
                    } else {
                        string2 = this.a.getString(R.string.her_fans_suffix);
                    }
                }
                textView.setText(string + String.valueOf(aqVar.a().c()) + string2);
                return;
            }
            linearLayout = this.a.c;
            linearLayout.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.data.aq aqVar) {
        cd cdVar;
        cd cdVar2;
        cd cdVar3;
        cd cdVar4;
        cd cdVar5;
        cd cdVar6;
        cd cdVar7;
        cd cdVar8;
        cd cdVar9;
        cd cdVar10;
        cd cdVar11;
        boolean z = true;
        cdVar = this.a.e;
        if (cdVar != null) {
            if (aqVar == null) {
                cdVar2 = this.a.e;
                cdVar2.a(false);
                cdVar3 = this.a.e;
                cdVar3.a(new ArrayList<>());
                cdVar4 = this.a.e;
                cdVar4.b(false);
                cdVar5 = this.a.e;
                cdVar5.b();
                cdVar6 = this.a.e;
                cdVar6.notifyDataSetChanged();
                return;
            }
            com.baidu.tieba.data.an a = aqVar.a();
            cdVar7 = this.a.e;
            if (a == null || a.f() != 1) {
                z = false;
            }
            cdVar7.a(z);
            cdVar8 = this.a.e;
            cdVar8.a(aqVar.b());
            cdVar9 = this.a.e;
            cdVar9.b(false);
            cdVar10 = this.a.e;
            cdVar10.b();
            cdVar11 = this.a.e;
            cdVar11.notifyDataSetChanged();
        }
    }
}
