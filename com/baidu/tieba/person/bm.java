package com.baidu.tieba.person;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.model.cb;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm extends BdAsyncTask<String, com.baidu.tieba.data.ap, com.baidu.tieba.data.ap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f2228a;
    private String b;
    private boolean c;
    private int d;
    private com.baidu.tieba.util.ap e = null;
    private boolean f;

    public bm(PersonListActivity personListActivity, String str, boolean z, int i, boolean z2) {
        this.f2228a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = z2;
    }

    public bm(PersonListActivity personListActivity, String str, boolean z, int i) {
        this.f2228a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bn bnVar;
        ProgressBar progressBar;
        bn bnVar2;
        bn bnVar3;
        if (this.e != null) {
            this.e.j();
        }
        bnVar = this.f2228a.e;
        if (bnVar != null) {
            bnVar2 = this.f2228a.e;
            bnVar2.b(false);
            bnVar3 = this.f2228a.e;
            bnVar3.notifyDataSetChanged();
        }
        progressBar = this.f2228a.d;
        progressBar.setVisibility(8);
        this.f2228a.g = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.ap a(String... strArr) {
        cb cbVar;
        cb cbVar2;
        cb cbVar3;
        cb cbVar4;
        this.e = new com.baidu.tieba.util.ap();
        com.baidu.tieba.data.ap apVar = null;
        if (this.f) {
            cbVar3 = this.f2228a.h;
            if (cbVar3 != null) {
                cbVar4 = this.f2228a.h;
                c((Object[]) new com.baidu.tieba.data.ap[]{cbVar4.b(this.c)});
            }
        }
        this.f = false;
        if (this.c) {
            this.e.a(com.baidu.tieba.data.h.f1201a + "c/u/follow/page");
        } else {
            this.e.a(com.baidu.tieba.data.h.f1201a + "c/u/fans/page");
        }
        if (this.b != null && !this.b.equals(TiebaApplication.A())) {
            this.e.a("uid", this.b);
        }
        if (this.d != 0) {
            this.e.a("pn", String.valueOf(this.d));
        }
        String l = this.e.l();
        if (this.e.c()) {
            apVar = new com.baidu.tieba.data.ap();
            apVar.a(l);
            if (apVar.a().d() == 1) {
                cbVar = this.f2228a.h;
                if (cbVar != null) {
                    cbVar2 = this.f2228a.h;
                    cbVar2.a(l, this.c);
                }
            }
        }
        return apVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(com.baidu.tieba.data.ap... apVarArr) {
        ProgressBar progressBar;
        ArrayList<UserData> b;
        super.b((Object[]) apVarArr);
        if (apVarArr.length >= 1) {
            com.baidu.tieba.data.ap apVar = apVarArr[0];
            if (apVar != null && (b = apVar.b()) != null && b.size() > 0) {
                a(apVar, true);
            }
            progressBar = this.f2228a.d;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ap apVar) {
        ProgressBar progressBar;
        progressBar = this.f2228a.d;
        progressBar.setVisibility(8);
        this.f2228a.g = null;
        if (this.e != null) {
            if (this.e.c()) {
                a(apVar, false);
            } else {
                a(apVar, true);
                this.f2228a.showToast(this.e.i());
            }
            super.a((bm) apVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r0.b().size() > 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void a(com.baidu.tieba.data.ap apVar, boolean z) {
        cb cbVar;
        com.baidu.tieba.data.ap apVar2;
        com.baidu.tieba.data.ap apVar3;
        com.baidu.tieba.data.ap apVar4;
        com.baidu.tieba.data.ap apVar5;
        com.baidu.tieba.data.ap apVar6;
        cb cbVar2;
        cbVar = this.f2228a.h;
        if (cbVar != null) {
            if (apVar == null) {
                apVar2 = this.f2228a.m;
                if (apVar2 != null) {
                    apVar4 = this.f2228a.m;
                    if (apVar4.b() != null) {
                        apVar5 = this.f2228a.m;
                    }
                }
                apVar3 = this.f2228a.m;
                d(apVar3);
            } else {
                if (z) {
                    apVar6 = apVar;
                } else {
                    b(apVar);
                    cbVar2 = this.f2228a.h;
                    apVar6 = cbVar2.d();
                }
                this.f2228a.m = apVar6;
                d(apVar6);
                if (!this.c) {
                    com.baidu.tieba.mention.t.a().c(0L);
                }
                c(apVar);
            }
        }
    }

    private void b(com.baidu.tieba.data.ap apVar) {
        cb cbVar;
        cb cbVar2;
        cbVar = this.f2228a.h;
        cbVar.d().b().addAll(apVar.b());
        cbVar2 = this.f2228a.h;
        cbVar2.d().a(apVar.a());
    }

    private void c(com.baidu.tieba.data.ap apVar) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        cb cbVar;
        String string;
        int i;
        int i2;
        String string2;
        cb cbVar2;
        cb cbVar3;
        int i3;
        int i4;
        String string3;
        cb cbVar4;
        if (this.d == 0) {
            if (apVar.a().c() > 0) {
                linearLayout2 = this.f2228a.c;
                linearLayout2.setVisibility(0);
                linearLayout3 = this.f2228a.c;
                TextView textView = (TextView) linearLayout3.findViewById(R.id.person_num);
                if (this.c) {
                    cbVar3 = this.f2228a.h;
                    if (cbVar3.a() != null) {
                        cbVar4 = this.f2228a.h;
                        if (cbVar4.a().equals(TiebaApplication.A())) {
                            string = this.f2228a.getString(R.string.my_attention_prefix);
                            string2 = this.f2228a.getString(R.string.person);
                        }
                    }
                    i3 = this.f2228a.l;
                    if (i3 != 2) {
                        i4 = this.f2228a.l;
                        if (i4 == 1) {
                            string3 = this.f2228a.getString(R.string.he_attention_prefix);
                        } else {
                            string3 = this.f2228a.getString(R.string.its_attention_prefix);
                        }
                    } else {
                        string3 = this.f2228a.getString(R.string.she_attention_prefix);
                    }
                    string = string3;
                    string2 = this.f2228a.getString(R.string.person);
                } else {
                    cbVar = this.f2228a.h;
                    if (cbVar.a() != null) {
                        cbVar2 = this.f2228a.h;
                        if (cbVar2.a().equals(TiebaApplication.A())) {
                            string = this.f2228a.getString(R.string.my_fans_prefix);
                            string2 = this.f2228a.getString(R.string.my_fans_suffix);
                        }
                    }
                    string = this.f2228a.getString(R.string.its_fans_prefix);
                    i = this.f2228a.l;
                    if (i != 2) {
                        i2 = this.f2228a.l;
                        if (i2 == 1) {
                            string2 = this.f2228a.getString(R.string.his_fans_suffix);
                        } else {
                            string2 = this.f2228a.getString(R.string.its_fans_suffix);
                        }
                    } else {
                        string2 = this.f2228a.getString(R.string.her_fans_suffix);
                    }
                }
                textView.setText(string + String.valueOf(apVar.a().c()) + string2);
                return;
            }
            linearLayout = this.f2228a.c;
            linearLayout.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.data.ap apVar) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        bn bnVar4;
        bn bnVar5;
        bn bnVar6;
        bn bnVar7;
        bn bnVar8;
        bn bnVar9;
        bn bnVar10;
        bn bnVar11;
        boolean z = true;
        bnVar = this.f2228a.e;
        if (bnVar != null) {
            if (apVar == null) {
                bnVar2 = this.f2228a.e;
                bnVar2.a(false);
                bnVar3 = this.f2228a.e;
                bnVar3.a(new ArrayList<>());
                bnVar4 = this.f2228a.e;
                bnVar4.b(false);
                bnVar5 = this.f2228a.e;
                bnVar5.b();
                bnVar6 = this.f2228a.e;
                bnVar6.notifyDataSetChanged();
                return;
            }
            com.baidu.tieba.data.am a2 = apVar.a();
            bnVar7 = this.f2228a.e;
            if (a2 == null || a2.f() != 1) {
                z = false;
            }
            bnVar7.a(z);
            bnVar8 = this.f2228a.e;
            bnVar8.a(apVar.b());
            bnVar9 = this.f2228a.e;
            bnVar9.b(false);
            bnVar10 = this.f2228a.e;
            bnVar10.b();
            bnVar11 = this.f2228a.e;
            bnVar11.notifyDataSetChanged();
        }
    }
}
