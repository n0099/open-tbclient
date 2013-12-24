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
public class bv extends BdAsyncTask<String, com.baidu.tieba.data.ap, com.baidu.tieba.data.ap> {
    final /* synthetic */ PersonListActivity a;
    private String b;
    private boolean c;
    private int d;
    private com.baidu.tieba.util.an e = null;
    private boolean f;

    public bv(PersonListActivity personListActivity, String str, boolean z, int i, boolean z2) {
        this.a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = z2;
    }

    public bv(PersonListActivity personListActivity, String str, boolean z, int i) {
        this.a = personListActivity;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bw bwVar;
        ProgressBar progressBar;
        bw bwVar2;
        bw bwVar3;
        if (this.e != null) {
            this.e.j();
        }
        bwVar = this.a.e;
        if (bwVar != null) {
            bwVar2 = this.a.e;
            bwVar2.b(false);
            bwVar3 = this.a.e;
            bwVar3.notifyDataSetChanged();
        }
        progressBar = this.a.d;
        progressBar.setVisibility(8);
        this.a.g = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.ap a(String... strArr) {
        com.baidu.tieba.model.ca caVar;
        com.baidu.tieba.model.ca caVar2;
        com.baidu.tieba.model.ca caVar3;
        com.baidu.tieba.model.ca caVar4;
        this.e = new com.baidu.tieba.util.an();
        com.baidu.tieba.data.ap apVar = null;
        if (this.f) {
            caVar3 = this.a.h;
            if (caVar3 != null) {
                caVar4 = this.a.h;
                c((Object[]) new com.baidu.tieba.data.ap[]{caVar4.b(this.c)});
            }
        }
        this.f = false;
        if (this.c) {
            this.e.a(com.baidu.tieba.data.h.a + "c/u/follow/page");
        } else {
            this.e.a(com.baidu.tieba.data.h.a + "c/u/fans/page");
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
                caVar = this.a.h;
                if (caVar != null) {
                    caVar2 = this.a.h;
                    caVar2.a(l, this.c);
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
            progressBar = this.a.d;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ap apVar) {
        ProgressBar progressBar;
        progressBar = this.a.d;
        progressBar.setVisibility(8);
        this.a.g = null;
        if (this.e != null) {
            if (this.e.c()) {
                a(apVar, false);
            } else {
                a(apVar, true);
                this.a.showToast(this.e.i());
            }
            super.a((bv) apVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r0.b().size() > 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void a(com.baidu.tieba.data.ap apVar, boolean z) {
        com.baidu.tieba.model.ca caVar;
        com.baidu.tieba.data.ap apVar2;
        com.baidu.tieba.data.ap apVar3;
        com.baidu.tieba.data.ap apVar4;
        com.baidu.tieba.data.ap apVar5;
        com.baidu.tieba.data.ap apVar6;
        com.baidu.tieba.model.ca caVar2;
        caVar = this.a.h;
        if (caVar != null) {
            if (apVar == null) {
                apVar2 = this.a.m;
                if (apVar2 != null) {
                    apVar4 = this.a.m;
                    if (apVar4.b() != null) {
                        apVar5 = this.a.m;
                    }
                }
                apVar3 = this.a.m;
                d(apVar3);
            } else {
                if (z) {
                    apVar6 = apVar;
                } else {
                    b(apVar);
                    caVar2 = this.a.h;
                    apVar6 = caVar2.d();
                }
                this.a.m = apVar6;
                d(apVar6);
                if (!this.c) {
                    com.baidu.tieba.mention.t.a().c(0L);
                }
                c(apVar);
            }
        }
    }

    private void b(com.baidu.tieba.data.ap apVar) {
        com.baidu.tieba.model.ca caVar;
        com.baidu.tieba.model.ca caVar2;
        caVar = this.a.h;
        caVar.d().b().addAll(apVar.b());
        caVar2 = this.a.h;
        caVar2.d().a(apVar.a());
    }

    private void c(com.baidu.tieba.data.ap apVar) {
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
            if (apVar.a().c() > 0) {
                linearLayout2 = this.a.c;
                linearLayout2.setVisibility(0);
                linearLayout3 = this.a.c;
                TextView textView = (TextView) linearLayout3.findViewById(R.id.person_num);
                if (this.c) {
                    caVar3 = this.a.h;
                    if (caVar3.a() != null) {
                        caVar4 = this.a.h;
                        if (caVar4.a().equals(TiebaApplication.B())) {
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
                        if (caVar2.a().equals(TiebaApplication.B())) {
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
                textView.setText(string + String.valueOf(apVar.a().c()) + string2);
                return;
            }
            linearLayout = this.a.c;
            linearLayout.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.data.ap apVar) {
        bw bwVar;
        bw bwVar2;
        bw bwVar3;
        bw bwVar4;
        bw bwVar5;
        bw bwVar6;
        bw bwVar7;
        bw bwVar8;
        bw bwVar9;
        bw bwVar10;
        bw bwVar11;
        boolean z = true;
        bwVar = this.a.e;
        if (bwVar != null) {
            if (apVar == null) {
                bwVar2 = this.a.e;
                bwVar2.a(false);
                bwVar3 = this.a.e;
                bwVar3.a(new ArrayList<>());
                bwVar4 = this.a.e;
                bwVar4.b(false);
                bwVar5 = this.a.e;
                bwVar5.b();
                bwVar6 = this.a.e;
                bwVar6.notifyDataSetChanged();
                return;
            }
            com.baidu.tieba.data.am a = apVar.a();
            bwVar7 = this.a.e;
            if (a == null || a.f() != 1) {
                z = false;
            }
            bwVar7.a(z);
            bwVar8 = this.a.e;
            bwVar8.a(apVar.b());
            bwVar9 = this.a.e;
            bwVar9.b(false);
            bwVar10 = this.a.e;
            bwVar10.b();
            bwVar11 = this.a.e;
            bwVar11.notifyDataSetChanged();
        }
    }
}
