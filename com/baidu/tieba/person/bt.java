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
public class bt extends BdAsyncTask<String, com.baidu.tieba.data.ap, com.baidu.tieba.data.ap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f2343a;
    private String b;
    private boolean c;
    private int d;
    private com.baidu.tieba.util.am e = null;
    private boolean f;

    public bt(PersonListActivity personListActivity, String str, boolean z, int i, boolean z2) {
        this.f2343a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = z2;
    }

    public bt(PersonListActivity personListActivity, String str, boolean z, int i) {
        this.f2343a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bu buVar;
        ProgressBar progressBar;
        bu buVar2;
        bu buVar3;
        if (this.e != null) {
            this.e.j();
        }
        buVar = this.f2343a.e;
        if (buVar != null) {
            buVar2 = this.f2343a.e;
            buVar2.b(false);
            buVar3 = this.f2343a.e;
            buVar3.notifyDataSetChanged();
        }
        progressBar = this.f2343a.d;
        progressBar.setVisibility(8);
        this.f2343a.g = null;
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
        this.e = new com.baidu.tieba.util.am();
        com.baidu.tieba.data.ap apVar = null;
        if (this.f) {
            cbVar3 = this.f2343a.h;
            if (cbVar3 != null) {
                cbVar4 = this.f2343a.h;
                c((Object[]) new com.baidu.tieba.data.ap[]{cbVar4.b(this.c)});
            }
        }
        this.f = false;
        if (this.c) {
            this.e.a(com.baidu.tieba.data.h.f1248a + "c/u/follow/page");
        } else {
            this.e.a(com.baidu.tieba.data.h.f1248a + "c/u/fans/page");
        }
        if (this.b != null && !this.b.equals(TiebaApplication.B())) {
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
                cbVar = this.f2343a.h;
                if (cbVar != null) {
                    cbVar2 = this.f2343a.h;
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
            progressBar = this.f2343a.d;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ap apVar) {
        ProgressBar progressBar;
        progressBar = this.f2343a.d;
        progressBar.setVisibility(8);
        this.f2343a.g = null;
        if (this.e != null) {
            if (this.e.c()) {
                a(apVar, false);
            } else {
                a(apVar, true);
                this.f2343a.showToast(this.e.i());
            }
            super.a((bt) apVar);
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
        cbVar = this.f2343a.h;
        if (cbVar != null) {
            if (apVar == null) {
                apVar2 = this.f2343a.m;
                if (apVar2 != null) {
                    apVar4 = this.f2343a.m;
                    if (apVar4.b() != null) {
                        apVar5 = this.f2343a.m;
                    }
                }
                apVar3 = this.f2343a.m;
                d(apVar3);
            } else {
                if (z) {
                    apVar6 = apVar;
                } else {
                    b(apVar);
                    cbVar2 = this.f2343a.h;
                    apVar6 = cbVar2.d();
                }
                this.f2343a.m = apVar6;
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
        cbVar = this.f2343a.h;
        cbVar.d().b().addAll(apVar.b());
        cbVar2 = this.f2343a.h;
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
                linearLayout2 = this.f2343a.c;
                linearLayout2.setVisibility(0);
                linearLayout3 = this.f2343a.c;
                TextView textView = (TextView) linearLayout3.findViewById(R.id.person_num);
                if (this.c) {
                    cbVar3 = this.f2343a.h;
                    if (cbVar3.a() != null) {
                        cbVar4 = this.f2343a.h;
                        if (cbVar4.a().equals(TiebaApplication.B())) {
                            string = this.f2343a.getString(R.string.my_attention_prefix);
                            string2 = this.f2343a.getString(R.string.person);
                        }
                    }
                    i3 = this.f2343a.l;
                    if (i3 != 2) {
                        i4 = this.f2343a.l;
                        if (i4 == 1) {
                            string3 = this.f2343a.getString(R.string.he_attention_prefix);
                        } else {
                            string3 = this.f2343a.getString(R.string.its_attention_prefix);
                        }
                    } else {
                        string3 = this.f2343a.getString(R.string.she_attention_prefix);
                    }
                    string = string3;
                    string2 = this.f2343a.getString(R.string.person);
                } else {
                    cbVar = this.f2343a.h;
                    if (cbVar.a() != null) {
                        cbVar2 = this.f2343a.h;
                        if (cbVar2.a().equals(TiebaApplication.B())) {
                            string = this.f2343a.getString(R.string.my_fans_prefix);
                            string2 = this.f2343a.getString(R.string.my_fans_suffix);
                        }
                    }
                    string = this.f2343a.getString(R.string.its_fans_prefix);
                    i = this.f2343a.l;
                    if (i != 2) {
                        i2 = this.f2343a.l;
                        if (i2 == 1) {
                            string2 = this.f2343a.getString(R.string.his_fans_suffix);
                        } else {
                            string2 = this.f2343a.getString(R.string.its_fans_suffix);
                        }
                    } else {
                        string2 = this.f2343a.getString(R.string.her_fans_suffix);
                    }
                }
                textView.setText(string + String.valueOf(apVar.a().c()) + string2);
                return;
            }
            linearLayout = this.f2343a.c;
            linearLayout.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.data.ap apVar) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        bu buVar4;
        bu buVar5;
        bu buVar6;
        bu buVar7;
        bu buVar8;
        bu buVar9;
        bu buVar10;
        bu buVar11;
        boolean z = true;
        buVar = this.f2343a.e;
        if (buVar != null) {
            if (apVar == null) {
                buVar2 = this.f2343a.e;
                buVar2.a(false);
                buVar3 = this.f2343a.e;
                buVar3.a(new ArrayList<>());
                buVar4 = this.f2343a.e;
                buVar4.b(false);
                buVar5 = this.f2343a.e;
                buVar5.b();
                buVar6 = this.f2343a.e;
                buVar6.notifyDataSetChanged();
                return;
            }
            com.baidu.tieba.data.am a2 = apVar.a();
            buVar7 = this.f2343a.e;
            if (a2 == null || a2.f() != 1) {
                z = false;
            }
            buVar7.a(z);
            buVar8 = this.f2343a.e;
            buVar8.a(apVar.b());
            buVar9 = this.f2343a.e;
            buVar9.b(false);
            buVar10 = this.f2343a.e;
            buVar10.b();
            buVar11 = this.f2343a.e;
            buVar11.notifyDataSetChanged();
        }
    }
}
