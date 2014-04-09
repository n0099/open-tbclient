package com.baidu.tieba.person;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ci extends BdAsyncTask<String, com.baidu.tieba.data.ag, com.baidu.tieba.data.ag> {
    final /* synthetic */ PersonListActivity a;
    private final String b;
    private final boolean c;
    private final int d;
    private com.baidu.tbadk.core.util.ak e;
    private boolean f;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ com.baidu.tieba.data.ag a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.ag agVar) {
        ProgressBar progressBar;
        com.baidu.tieba.data.ag agVar2 = agVar;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        this.a.i = null;
        if (this.e != null) {
            if (this.e.a().b().b()) {
                a(agVar2, false);
            } else {
                a(agVar2, true);
                this.a.showToast(this.e.f());
            }
            super.a((ci) agVar2);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(com.baidu.tieba.data.ag... agVarArr) {
        ProgressBar progressBar;
        ArrayList<UserData> b;
        com.baidu.tieba.data.ag[] agVarArr2 = agVarArr;
        super.b((Object[]) agVarArr2);
        if (agVarArr2.length <= 0) {
            return;
        }
        com.baidu.tieba.data.ag agVar = agVarArr2[0];
        if (agVar != null && (b = agVar.b()) != null && b.size() > 0) {
            a(agVar, true);
        }
        progressBar = this.a.f;
        progressBar.setVisibility(0);
    }

    public ci(PersonListActivity personListActivity, String str, boolean z, int i, boolean z2) {
        this.a = personListActivity;
        this.e = null;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = 0;
        this.f = true;
    }

    public ci(PersonListActivity personListActivity, String str, boolean z, int i) {
        this.a = personListActivity;
        this.e = null;
        this.f = false;
        this.b = str;
        this.c = z;
        this.d = i;
        this.f = false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        cj cjVar;
        ProgressBar progressBar;
        cj cjVar2;
        cj cjVar3;
        if (this.e != null) {
            this.e.g();
        }
        cjVar = this.a.g;
        if (cjVar != null) {
            cjVar2 = this.a.g;
            cjVar2.b(false);
            cjVar3 = this.a.g;
            cjVar3.notifyDataSetChanged();
        }
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        this.a.i = null;
        super.cancel(true);
    }

    private com.baidu.tieba.data.ag a() {
        com.baidu.tieba.model.ay ayVar;
        com.baidu.tieba.model.ay ayVar2;
        com.baidu.tieba.model.ay ayVar3;
        com.baidu.tieba.model.ay ayVar4;
        this.e = new com.baidu.tbadk.core.util.ak();
        com.baidu.tieba.data.ag agVar = null;
        if (this.f) {
            ayVar3 = this.a.j;
            if (ayVar3 != null) {
                ayVar4 = this.a.j;
                c((Object[]) new com.baidu.tieba.data.ag[]{ayVar4.b(this.c)});
            }
        }
        this.f = false;
        if (this.c) {
            this.e.a(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/u/follow/page");
        } else {
            this.e.a(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/u/fans/page");
        }
        if (this.b != null && !this.b.equals(TbadkApplication.E())) {
            this.e.a("uid", this.b);
        }
        if (this.d != 0) {
            this.e.a("pn", String.valueOf(this.d));
        }
        String i = this.e.i();
        if (this.e.a().b().b()) {
            agVar = new com.baidu.tieba.data.ag();
            agVar.a(i);
            if (agVar.a().d() == 1) {
                ayVar = this.a.j;
                if (ayVar != null) {
                    ayVar2 = this.a.j;
                    ayVar2.a(i, this.c);
                }
            }
        }
        return agVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x02e4, code lost:
        if (r0.b().size() > 0) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void a(com.baidu.tieba.data.ag agVar, boolean z) {
        com.baidu.tieba.model.ay ayVar;
        com.baidu.tieba.data.ag agVar2;
        com.baidu.tieba.data.ag agVar3;
        com.baidu.tieba.data.ag agVar4;
        com.baidu.tieba.data.ag agVar5;
        com.baidu.tieba.data.ag agVar6;
        View view;
        BdListView bdListView;
        LinearLayout linearLayout;
        com.baidu.tieba.model.ay ayVar2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        com.baidu.tieba.model.ay ayVar3;
        TextView textView4;
        com.baidu.tieba.model.ay ayVar4;
        int i3;
        int i4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        com.baidu.tieba.model.ay ayVar5;
        TextView textView8;
        View view2;
        BdListView bdListView2;
        LinearLayout linearLayout2;
        com.baidu.tieba.model.ay ayVar6;
        String string;
        int i5;
        int i6;
        String string2;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        com.baidu.tieba.model.ay ayVar7;
        TextView textView12;
        TextView textView13;
        com.baidu.tieba.model.ay ayVar8;
        int i7;
        int i8;
        TextView textView14;
        TextView textView15;
        TextView textView16;
        com.baidu.tieba.model.ay ayVar9;
        TextView textView17;
        com.baidu.tieba.model.ay ayVar10;
        com.baidu.tieba.model.ay ayVar11;
        com.baidu.tieba.model.ay ayVar12;
        ayVar = this.a.j;
        if (ayVar != null) {
            if (agVar == null) {
                agVar2 = this.a.q;
                if (agVar2 != null) {
                    agVar4 = this.a.q;
                    if (agVar4.b() != null) {
                        agVar5 = this.a.q;
                    }
                }
                agVar3 = this.a.q;
                a2(agVar3);
            } else {
                if (z) {
                    agVar6 = agVar;
                } else {
                    ayVar10 = this.a.j;
                    ayVar10.d().b().addAll(agVar.b());
                    ayVar11 = this.a.j;
                    ayVar11.d().a(agVar.a());
                    ayVar12 = this.a.j;
                    agVar6 = ayVar12.d();
                }
                this.a.q = agVar6;
                a2(agVar6);
                if (!this.c) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.a().d(0);
                }
                if (this.d == 0) {
                    if (agVar.a().c() > 0) {
                        view2 = this.a.c;
                        view2.setVisibility(0);
                        bdListView2 = this.a.b;
                        bdListView2.setVisibility(0);
                        linearLayout2 = this.a.k;
                        linearLayout2.setVisibility(8);
                        if (this.c) {
                            ayVar8 = this.a.j;
                            if (ayVar8.a() != null) {
                                ayVar9 = this.a.j;
                                if (ayVar9.a().equals(TbadkApplication.E())) {
                                    string = this.a.getString(com.baidu.tieba.a.k.my_attention_prefix);
                                    string2 = this.a.getString(com.baidu.tieba.a.k.person);
                                    textView17 = this.a.l;
                                    textView17.setText(com.baidu.tieba.a.k.not_have_attention);
                                }
                            }
                            i7 = this.a.p;
                            if (i7 == 2) {
                                string = this.a.getString(com.baidu.tieba.a.k.she_attention_prefix);
                                textView16 = this.a.l;
                                textView16.setText(com.baidu.tieba.a.k.her_no_attention_other);
                            } else {
                                i8 = this.a.p;
                                if (i8 == 1) {
                                    string = this.a.getString(com.baidu.tieba.a.k.he_attention_prefix);
                                    textView15 = this.a.l;
                                    textView15.setText(com.baidu.tieba.a.k.him_no_attention_other);
                                } else {
                                    string = this.a.getString(com.baidu.tieba.a.k.its_attention_prefix);
                                    textView14 = this.a.l;
                                    textView14.setText(com.baidu.tieba.a.k.no_attention_other);
                                }
                            }
                            string2 = this.a.getString(com.baidu.tieba.a.k.person);
                        } else {
                            ayVar6 = this.a.j;
                            if (ayVar6.a() != null) {
                                ayVar7 = this.a.j;
                                if (ayVar7.a().equals(TbadkApplication.E())) {
                                    string = this.a.getString(com.baidu.tieba.a.k.my_fans_prefix);
                                    string2 = this.a.getString(com.baidu.tieba.a.k.my_fans_suffix);
                                    textView12 = this.a.l;
                                    textView12.setText(com.baidu.tieba.a.k.not_have_fans);
                                }
                            }
                            string = this.a.getString(com.baidu.tieba.a.k.its_fans_prefix);
                            i5 = this.a.p;
                            if (i5 == 2) {
                                string2 = this.a.getString(com.baidu.tieba.a.k.her_fans_suffix);
                                textView11 = this.a.l;
                                textView11.setText(com.baidu.tieba.a.k.her_no_fan_other);
                            } else {
                                i6 = this.a.p;
                                if (i6 == 1) {
                                    string2 = this.a.getString(com.baidu.tieba.a.k.his_fans_suffix);
                                    textView10 = this.a.l;
                                    textView10.setText(com.baidu.tieba.a.k.him_no_fan_other);
                                } else {
                                    string2 = this.a.getString(com.baidu.tieba.a.k.its_fans_suffix);
                                    textView9 = this.a.l;
                                    textView9.setText(com.baidu.tieba.a.k.no_fan_other);
                                }
                            }
                        }
                        textView13 = this.a.e;
                        textView13.setText(String.valueOf(string) + String.valueOf(agVar.a().c()) + string2);
                    } else {
                        view = this.a.c;
                        view.setVisibility(8);
                        bdListView = this.a.b;
                        bdListView.setVisibility(8);
                        linearLayout = this.a.k;
                        linearLayout.setVisibility(0);
                        if (this.c) {
                            ayVar4 = this.a.j;
                            if (ayVar4.a() != null) {
                                ayVar5 = this.a.j;
                                if (ayVar5.a().equals(TbadkApplication.E())) {
                                    textView8 = this.a.l;
                                    textView8.setText(com.baidu.tieba.a.k.not_have_attention);
                                }
                            }
                            i3 = this.a.p;
                            if (i3 == 2) {
                                textView7 = this.a.l;
                                textView7.setText(com.baidu.tieba.a.k.her_no_attention_other);
                            } else {
                                i4 = this.a.p;
                                if (i4 == 1) {
                                    textView6 = this.a.l;
                                    textView6.setText(com.baidu.tieba.a.k.him_no_attention_other);
                                } else {
                                    textView5 = this.a.l;
                                    textView5.setText(com.baidu.tieba.a.k.no_attention_other);
                                }
                            }
                        } else {
                            ayVar2 = this.a.j;
                            if (ayVar2.a() != null) {
                                ayVar3 = this.a.j;
                                if (ayVar3.a().equals(TbadkApplication.E())) {
                                    textView4 = this.a.l;
                                    textView4.setText(com.baidu.tieba.a.k.not_have_fans);
                                }
                            }
                            i = this.a.p;
                            if (i == 2) {
                                textView3 = this.a.l;
                                textView3.setText(com.baidu.tieba.a.k.her_no_fan_other);
                            } else {
                                i2 = this.a.p;
                                if (i2 == 1) {
                                    textView2 = this.a.l;
                                    textView2.setText(com.baidu.tieba.a.k.him_no_fan_other);
                                } else {
                                    textView = this.a.l;
                                    textView.setText(com.baidu.tieba.a.k.no_fan_other);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private void a2(com.baidu.tieba.data.ag agVar) {
        cj cjVar;
        cj cjVar2;
        cj cjVar3;
        cj cjVar4;
        cj cjVar5;
        cj cjVar6;
        cj cjVar7;
        cj cjVar8;
        cj cjVar9;
        cj cjVar10;
        cj cjVar11;
        boolean z = true;
        cjVar = this.a.g;
        if (cjVar != null) {
            if (agVar == null) {
                cjVar2 = this.a.g;
                cjVar2.a(false);
                cjVar3 = this.a.g;
                cjVar3.a(new ArrayList<>());
                cjVar4 = this.a.g;
                cjVar4.b(false);
                cjVar5 = this.a.g;
                cjVar5.b();
                cjVar6 = this.a.g;
                cjVar6.notifyDataSetChanged();
                return;
            }
            com.baidu.tbadk.core.data.l a = agVar.a();
            cjVar7 = this.a.g;
            if (a == null || a.f() != 1) {
                z = false;
            }
            cjVar7.a(z);
            cjVar8 = this.a.g;
            cjVar8.a(agVar.b());
            cjVar9 = this.a.g;
            cjVar9.b(false);
            cjVar10 = this.a.g;
            cjVar10.b();
            cjVar11 = this.a.g;
            cjVar11.notifyDataSetChanged();
        }
    }
}
