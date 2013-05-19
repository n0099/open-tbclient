package com.baidu.tieba.nearby;

import android.app.AlertDialog;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.lib.a.a {
    ArrayList a;
    final /* synthetic */ NearbyPbActivity b;
    private int d;
    private String e;
    private com.baidu.tieba.d.t c = null;
    private volatile long f = 0;

    public aa(NearbyPbActivity nearbyPbActivity, String str, ArrayList arrayList, int i) {
        this.b = nearbyPbActivity;
        this.d = 3;
        this.e = null;
        this.a = null;
        this.e = str;
        this.a = arrayList;
        this.d = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public com.baidu.tieba.a.al a(Object... objArr) {
        com.baidu.tieba.a.al alVar;
        Exception e;
        long j;
        long j2;
        int i;
        int i2;
        long j3;
        long j4;
        try {
            this.c = new com.baidu.tieba.d.t(this.e);
            this.c.a(this.a);
            j = NearbyPbActivity.B;
            if (j != 0) {
                com.baidu.tieba.d.t tVar = this.c;
                j4 = NearbyPbActivity.B;
                tVar.a("ctime", String.valueOf(j4));
            }
            j2 = NearbyPbActivity.C;
            if (j2 != 0) {
                com.baidu.tieba.d.t tVar2 = this.c;
                j3 = NearbyPbActivity.C;
                tVar2.a("data_size", String.valueOf(j3));
            }
            i = NearbyPbActivity.D;
            if (i != 0) {
                com.baidu.tieba.d.t tVar3 = this.c;
                i2 = NearbyPbActivity.D;
                tVar3.a("net_error", String.valueOf(i2));
            }
            String i3 = this.c.i();
            if (this.c.b()) {
                com.baidu.tieba.a.al alVar2 = new com.baidu.tieba.a.al();
                try {
                    alVar2.b(i3);
                    int size = alVar2.d().size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((com.baidu.tieba.a.aq) alVar2.d().get(i4)).d(this.b);
                        ((com.baidu.tieba.a.aq) alVar2.d().get(i4)).a((ArrayList) null);
                    }
                    alVar = alVar2;
                } catch (Exception e2) {
                    e = e2;
                    alVar = alVar2;
                    com.baidu.tieba.d.ae.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return alVar;
                }
            } else {
                alVar = null;
            }
            try {
                if (this.c.c()) {
                    NearbyPbActivity.B = 0L;
                    NearbyPbActivity.C = 0L;
                    NearbyPbActivity.D = 0;
                } else {
                    NearbyPbActivity.D = 1;
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.tieba.d.ae.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
                return alVar;
            }
        } catch (Exception e4) {
            alVar = null;
            e = e4;
        }
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.al alVar) {
        LinearLayout linearLayout;
        com.baidu.tieba.c.bd bdVar;
        com.baidu.tieba.c.bd bdVar2;
        com.baidu.tieba.c.bd bdVar3;
        com.baidu.tieba.c.bd bdVar4;
        com.baidu.tieba.c.bd bdVar5;
        com.baidu.tieba.c.bd bdVar6;
        com.baidu.tieba.c.bd bdVar7;
        com.baidu.tieba.c.bd bdVar8;
        ae aeVar;
        ae aeVar2;
        com.baidu.tieba.c.bd bdVar9;
        com.baidu.tieba.c.bd bdVar10;
        com.baidu.tieba.c.bd bdVar11;
        com.baidu.tieba.c.bd bdVar12;
        com.baidu.tieba.c.bd bdVar13;
        com.baidu.tieba.c.bd bdVar14;
        ListView listView;
        com.baidu.tieba.c.bd bdVar15;
        com.baidu.tieba.c.bd bdVar16;
        com.baidu.tieba.c.bd bdVar17;
        com.baidu.tieba.c.bd bdVar18;
        ae aeVar3;
        ListView listView2;
        ae aeVar4;
        com.baidu.tieba.c.bd bdVar19;
        com.baidu.tieba.c.bd bdVar20;
        com.baidu.tieba.c.bd bdVar21;
        com.baidu.tieba.c.bd bdVar22;
        com.baidu.tieba.c.bd bdVar23;
        com.baidu.tieba.c.bd bdVar24;
        com.baidu.tieba.c.bd bdVar25;
        com.baidu.tieba.c.bd bdVar26;
        ae aeVar5;
        ae aeVar6;
        ae aeVar7;
        ae aeVar8;
        try {
            if (alVar != null) {
                bdVar = this.b.n;
                com.baidu.tieba.a.al a = bdVar.a();
                this.b.u = null;
                bdVar2 = this.b.n;
                bdVar2.c(alVar.e().e());
                bdVar3 = this.b.n;
                bdVar3.d(alVar.e().f());
                if (this.d == 3) {
                    bdVar22 = this.b.n;
                    bdVar22.a(alVar);
                    bdVar23 = this.b.n;
                    bdVar24 = this.b.n;
                    bdVar23.a(bdVar24.a().e().c());
                    bdVar25 = this.b.n;
                    bdVar26 = this.b.n;
                    bdVar25.b(bdVar26.a().e().c());
                    if (alVar.e().e() == 1) {
                        aeVar8 = this.b.l;
                        aeVar8.b(2);
                    } else {
                        aeVar5 = this.b.l;
                        aeVar5.b(1);
                    }
                    if (alVar.e().f() == 1) {
                        aeVar7 = this.b.l;
                        aeVar7.a(2);
                    } else {
                        aeVar6 = this.b.l;
                        aeVar6.a(0);
                    }
                    alVar.i();
                } else if (a != null && this.d == 2) {
                    listView = this.b.d;
                    int firstVisiblePosition = listView.getFirstVisiblePosition();
                    ArrayList d = a.d();
                    ArrayList d2 = alVar.d();
                    int size = firstVisiblePosition + d2.size();
                    d.addAll(0, d2);
                    a.a(alVar.e(), 0);
                    a.a(alVar.a());
                    a.a(alVar.b());
                    a.a(alVar.f());
                    bdVar15 = this.b.n;
                    bdVar15.b(alVar.e().c());
                    bdVar16 = this.b.n;
                    int c = bdVar16.c();
                    bdVar17 = this.b.n;
                    int d3 = c - bdVar17.d();
                    bdVar18 = this.b.n;
                    if (d3 >= bdVar18.f()) {
                        bdVar19 = this.b.n;
                        bdVar20 = this.b.n;
                        int d4 = bdVar20.d();
                        bdVar21 = this.b.n;
                        bdVar19.a((d4 + bdVar21.f()) - 1);
                    }
                    if (a.e().f() == 1) {
                        aeVar4 = this.b.l;
                        aeVar4.a(2);
                    } else {
                        aeVar3 = this.b.l;
                        aeVar3.a(0);
                    }
                    listView2 = this.b.d;
                    listView2.setSelection(size);
                } else if (a != null && this.d == 1) {
                    a.d().addAll(alVar.d());
                    a.a(alVar.e(), 0);
                    a.a(alVar.a());
                    a.a(alVar.b());
                    a.a(alVar.f());
                    bdVar4 = this.b.n;
                    if (!bdVar4.e()) {
                        bdVar5 = this.b.n;
                        bdVar5.a(alVar.e().c());
                    } else if (a.e().e() == 1) {
                        bdVar13 = this.b.n;
                        bdVar14 = this.b.n;
                        bdVar13.a(bdVar14.c() + 1);
                    } else {
                        bdVar12 = this.b.n;
                        bdVar12.a(alVar.e().a());
                    }
                    bdVar6 = this.b.n;
                    int c2 = bdVar6.c();
                    bdVar7 = this.b.n;
                    int d5 = c2 - bdVar7.d();
                    bdVar8 = this.b.n;
                    if (d5 >= bdVar8.f()) {
                        bdVar9 = this.b.n;
                        bdVar10 = this.b.n;
                        int c3 = bdVar10.c();
                        bdVar11 = this.b.n;
                        bdVar9.b((c3 - bdVar11.f()) + 1);
                    }
                    if (a.e().e() == 1) {
                        aeVar2 = this.b.l;
                        aeVar2.b(2);
                    } else {
                        aeVar = this.b.l;
                        aeVar.b(1);
                    }
                }
                NearbyPbActivity.B = (System.nanoTime() - this.f) / 1000000;
                if (this.c != null) {
                    NearbyPbActivity.C = this.c.a();
                }
            } else if (this.c != null) {
                if (this.d == 3) {
                    if (this.c.c()) {
                        this.b.a(this.c.f());
                        if (this.c.d() == 4 || this.c.d() == 28) {
                            this.b.f();
                            return;
                        }
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
                        builder.setTitle(this.b.getString(R.string.error));
                        builder.setMessage(this.c.f());
                        builder.setPositiveButton(this.b.getString(R.string.retry), new ab(this));
                        builder.setNegativeButton(this.b.getString(R.string.cancel), new ac(this));
                        builder.create().show();
                    }
                } else {
                    this.b.a(this.c.f());
                }
            }
            this.b.v();
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        this.b.m = null;
        e();
        if (this.d == 3) {
            linearLayout = this.b.s;
            linearLayout.invalidate();
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        if (this.c != null) {
            this.c.g();
        }
        e();
        super.cancel(true);
    }

    private void e() {
        ProgressBar progressBar;
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        ae aeVar4;
        ae aeVar5;
        ae aeVar6;
        ae aeVar7;
        ae aeVar8;
        ProgressBar progressBar2;
        progressBar = this.b.p;
        if (progressBar.getVisibility() == 0) {
            progressBar2 = this.b.p;
            progressBar2.setVisibility(8);
        }
        aeVar = this.b.l;
        if (aeVar.e()) {
            aeVar6 = this.b.l;
            aeVar6.a(false);
            aeVar7 = this.b.l;
            if (aeVar7.d()) {
                aeVar8 = this.b.l;
                aeVar8.notifyDataSetChanged();
            }
        }
        aeVar2 = this.b.l;
        if (aeVar2.f()) {
            aeVar3 = this.b.l;
            aeVar3.b(false);
            aeVar4 = this.b.l;
            if (aeVar4.c()) {
                aeVar5 = this.b.l;
                aeVar5.notifyDataSetInvalidated();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        super.b();
        this.f = System.nanoTime();
    }
}
