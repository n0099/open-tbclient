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
    public com.baidu.tieba.a.am a(Object... objArr) {
        com.baidu.tieba.a.am amVar;
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
                com.baidu.tieba.a.am amVar2 = new com.baidu.tieba.a.am();
                try {
                    amVar2.b(i3);
                    int size = amVar2.d().size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((com.baidu.tieba.a.ar) amVar2.d().get(i4)).c(this.b);
                        ((com.baidu.tieba.a.ar) amVar2.d().get(i4)).a((ArrayList) null);
                    }
                    amVar = amVar2;
                } catch (Exception e2) {
                    e = e2;
                    amVar = amVar2;
                    com.baidu.tieba.d.ae.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return amVar;
                }
            } else {
                amVar = null;
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
                return amVar;
            }
        } catch (Exception e4) {
            amVar = null;
            e = e4;
        }
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.am amVar) {
        LinearLayout linearLayout;
        com.baidu.tieba.c.bg bgVar;
        com.baidu.tieba.c.bg bgVar2;
        com.baidu.tieba.c.bg bgVar3;
        com.baidu.tieba.c.bg bgVar4;
        com.baidu.tieba.c.bg bgVar5;
        com.baidu.tieba.c.bg bgVar6;
        com.baidu.tieba.c.bg bgVar7;
        com.baidu.tieba.c.bg bgVar8;
        ae aeVar;
        ae aeVar2;
        com.baidu.tieba.c.bg bgVar9;
        com.baidu.tieba.c.bg bgVar10;
        com.baidu.tieba.c.bg bgVar11;
        com.baidu.tieba.c.bg bgVar12;
        com.baidu.tieba.c.bg bgVar13;
        com.baidu.tieba.c.bg bgVar14;
        ListView listView;
        com.baidu.tieba.c.bg bgVar15;
        com.baidu.tieba.c.bg bgVar16;
        com.baidu.tieba.c.bg bgVar17;
        com.baidu.tieba.c.bg bgVar18;
        ae aeVar3;
        ListView listView2;
        ae aeVar4;
        com.baidu.tieba.c.bg bgVar19;
        com.baidu.tieba.c.bg bgVar20;
        com.baidu.tieba.c.bg bgVar21;
        com.baidu.tieba.c.bg bgVar22;
        com.baidu.tieba.c.bg bgVar23;
        com.baidu.tieba.c.bg bgVar24;
        com.baidu.tieba.c.bg bgVar25;
        com.baidu.tieba.c.bg bgVar26;
        ae aeVar5;
        ae aeVar6;
        ae aeVar7;
        ae aeVar8;
        try {
            if (amVar != null) {
                bgVar = this.b.n;
                com.baidu.tieba.a.am a = bgVar.a();
                this.b.u = null;
                bgVar2 = this.b.n;
                bgVar2.c(amVar.e().f());
                bgVar3 = this.b.n;
                bgVar3.d(amVar.e().g());
                if (this.d == 3) {
                    bgVar22 = this.b.n;
                    bgVar22.a(amVar);
                    bgVar23 = this.b.n;
                    bgVar24 = this.b.n;
                    bgVar23.a(bgVar24.a().e().d());
                    bgVar25 = this.b.n;
                    bgVar26 = this.b.n;
                    bgVar25.b(bgVar26.a().e().d());
                    if (amVar.e().f() == 1) {
                        aeVar8 = this.b.l;
                        aeVar8.b(2);
                    } else {
                        aeVar5 = this.b.l;
                        aeVar5.b(1);
                    }
                    if (amVar.e().g() == 1) {
                        aeVar7 = this.b.l;
                        aeVar7.a(2);
                    } else {
                        aeVar6 = this.b.l;
                        aeVar6.a(0);
                    }
                    amVar.i();
                } else if (a != null && this.d == 2) {
                    listView = this.b.d;
                    int firstVisiblePosition = listView.getFirstVisiblePosition();
                    ArrayList d = a.d();
                    ArrayList d2 = amVar.d();
                    int size = firstVisiblePosition + d2.size();
                    d.addAll(0, d2);
                    a.a(amVar.e(), 0);
                    a.a(amVar.a());
                    a.a(amVar.b());
                    a.a(amVar.f());
                    bgVar15 = this.b.n;
                    bgVar15.b(amVar.e().d());
                    bgVar16 = this.b.n;
                    int c = bgVar16.c();
                    bgVar17 = this.b.n;
                    int d3 = c - bgVar17.d();
                    bgVar18 = this.b.n;
                    if (d3 >= bgVar18.f()) {
                        bgVar19 = this.b.n;
                        bgVar20 = this.b.n;
                        int d4 = bgVar20.d();
                        bgVar21 = this.b.n;
                        bgVar19.a((d4 + bgVar21.f()) - 1);
                    }
                    if (a.e().g() == 1) {
                        aeVar4 = this.b.l;
                        aeVar4.a(2);
                    } else {
                        aeVar3 = this.b.l;
                        aeVar3.a(0);
                    }
                    listView2 = this.b.d;
                    listView2.setSelection(size);
                } else if (a != null && this.d == 1) {
                    a.d().addAll(amVar.d());
                    a.a(amVar.e(), 0);
                    a.a(amVar.a());
                    a.a(amVar.b());
                    a.a(amVar.f());
                    bgVar4 = this.b.n;
                    if (!bgVar4.e()) {
                        bgVar5 = this.b.n;
                        bgVar5.a(amVar.e().d());
                    } else if (a.e().f() == 1) {
                        bgVar13 = this.b.n;
                        bgVar14 = this.b.n;
                        bgVar13.a(bgVar14.c() + 1);
                    } else {
                        bgVar12 = this.b.n;
                        bgVar12.a(amVar.e().a());
                    }
                    bgVar6 = this.b.n;
                    int c2 = bgVar6.c();
                    bgVar7 = this.b.n;
                    int d5 = c2 - bgVar7.d();
                    bgVar8 = this.b.n;
                    if (d5 >= bgVar8.f()) {
                        bgVar9 = this.b.n;
                        bgVar10 = this.b.n;
                        int c3 = bgVar10.c();
                        bgVar11 = this.b.n;
                        bgVar9.b((c3 - bgVar11.f()) + 1);
                    }
                    if (a.e().f() == 1) {
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
