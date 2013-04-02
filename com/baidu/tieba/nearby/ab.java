package com.baidu.tieba.nearby;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends AsyncTask {
    ArrayList a;
    final /* synthetic */ NearbyPbActivity b;
    private int d;
    private String e;
    private com.baidu.tieba.c.t c = null;
    private volatile long f = 0;

    public ab(NearbyPbActivity nearbyPbActivity, String str, ArrayList arrayList, int i) {
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
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.ak doInBackground(Object... objArr) {
        com.baidu.tieba.a.ak akVar;
        Exception e;
        long j;
        long j2;
        int i;
        int i2;
        long j3;
        long j4;
        try {
            this.c = new com.baidu.tieba.c.t(this.e);
            this.c.a(this.a);
            j = NearbyPbActivity.C;
            if (j != 0) {
                com.baidu.tieba.c.t tVar = this.c;
                j4 = NearbyPbActivity.C;
                tVar.a("ctime", String.valueOf(j4));
            }
            j2 = NearbyPbActivity.D;
            if (j2 != 0) {
                com.baidu.tieba.c.t tVar2 = this.c;
                j3 = NearbyPbActivity.D;
                tVar2.a("data_size", String.valueOf(j3));
            }
            i = NearbyPbActivity.E;
            if (i != 0) {
                com.baidu.tieba.c.t tVar3 = this.c;
                i2 = NearbyPbActivity.E;
                tVar3.a("net_error", String.valueOf(i2));
            }
            String i3 = this.c.i();
            if (this.c.b()) {
                com.baidu.tieba.a.ak akVar2 = new com.baidu.tieba.a.ak();
                try {
                    akVar2.a(i3);
                    int size = akVar2.d().size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((com.baidu.tieba.a.an) akVar2.d().get(i4)).b(this.b);
                        ((com.baidu.tieba.a.an) akVar2.d().get(i4)).a((ArrayList) null);
                    }
                    akVar = akVar2;
                } catch (Exception e2) {
                    e = e2;
                    akVar = akVar2;
                    com.baidu.tieba.c.ag.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return akVar;
                }
            } else {
                akVar = null;
            }
            try {
                if (this.c.c()) {
                    NearbyPbActivity.C = 0L;
                    NearbyPbActivity.D = 0L;
                    NearbyPbActivity.E = 0;
                } else {
                    NearbyPbActivity.E = 1;
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.tieba.c.ag.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
                return akVar;
            }
        } catch (Exception e4) {
            akVar = null;
            e = e4;
        }
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.ak akVar) {
        LinearLayout linearLayout;
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        com.baidu.tieba.b.r rVar3;
        com.baidu.tieba.b.r rVar4;
        com.baidu.tieba.b.r rVar5;
        com.baidu.tieba.b.r rVar6;
        com.baidu.tieba.b.r rVar7;
        com.baidu.tieba.b.r rVar8;
        af afVar;
        af afVar2;
        com.baidu.tieba.b.r rVar9;
        com.baidu.tieba.b.r rVar10;
        com.baidu.tieba.b.r rVar11;
        com.baidu.tieba.b.r rVar12;
        com.baidu.tieba.b.r rVar13;
        com.baidu.tieba.b.r rVar14;
        ListView listView;
        com.baidu.tieba.b.r rVar15;
        com.baidu.tieba.b.r rVar16;
        com.baidu.tieba.b.r rVar17;
        com.baidu.tieba.b.r rVar18;
        af afVar3;
        ListView listView2;
        af afVar4;
        com.baidu.tieba.b.r rVar19;
        com.baidu.tieba.b.r rVar20;
        com.baidu.tieba.b.r rVar21;
        com.baidu.tieba.b.r rVar22;
        com.baidu.tieba.b.r rVar23;
        com.baidu.tieba.b.r rVar24;
        com.baidu.tieba.b.r rVar25;
        com.baidu.tieba.b.r rVar26;
        af afVar5;
        af afVar6;
        af afVar7;
        af afVar8;
        try {
            if (akVar != null) {
                rVar = this.b.o;
                com.baidu.tieba.a.ak a = rVar.a();
                this.b.v = null;
                rVar2 = this.b.o;
                rVar2.c(akVar.e().c());
                rVar3 = this.b.o;
                rVar3.d(akVar.e().d());
                if (this.d == 3) {
                    rVar22 = this.b.o;
                    rVar22.a(akVar);
                    rVar23 = this.b.o;
                    rVar24 = this.b.o;
                    rVar23.a(rVar24.a().e().b());
                    rVar25 = this.b.o;
                    rVar26 = this.b.o;
                    rVar25.b(rVar26.a().e().b());
                    if (akVar.e().c() == 1) {
                        afVar8 = this.b.m;
                        afVar8.b(2);
                    } else {
                        afVar5 = this.b.m;
                        afVar5.b(1);
                    }
                    if (akVar.e().d() == 1) {
                        afVar7 = this.b.m;
                        afVar7.a(2);
                    } else {
                        afVar6 = this.b.m;
                        afVar6.a(0);
                    }
                    akVar.i();
                } else if (a != null && this.d == 2) {
                    listView = this.b.d;
                    int firstVisiblePosition = listView.getFirstVisiblePosition();
                    ArrayList d = a.d();
                    ArrayList d2 = akVar.d();
                    int size = firstVisiblePosition + d2.size();
                    d.addAll(0, d2);
                    a.a(akVar.e());
                    a.a(akVar.a());
                    a.a(akVar.b());
                    a.a(akVar.f());
                    rVar15 = this.b.o;
                    rVar15.b(akVar.e().b());
                    rVar16 = this.b.o;
                    int k = rVar16.k();
                    rVar17 = this.b.o;
                    int l = k - rVar17.l();
                    rVar18 = this.b.o;
                    if (l >= rVar18.o()) {
                        rVar19 = this.b.o;
                        rVar20 = this.b.o;
                        int l2 = rVar20.l();
                        rVar21 = this.b.o;
                        rVar19.a((l2 + rVar21.o()) - 1);
                    }
                    if (a.e().d() == 1) {
                        afVar4 = this.b.m;
                        afVar4.a(2);
                    } else {
                        afVar3 = this.b.m;
                        afVar3.a(0);
                    }
                    listView2 = this.b.d;
                    listView2.setSelection(size);
                } else if (a != null && this.d == 1) {
                    a.d().addAll(akVar.d());
                    a.a(akVar.e());
                    a.a(akVar.a());
                    a.a(akVar.b());
                    a.a(akVar.f());
                    rVar4 = this.b.o;
                    if (!rVar4.m()) {
                        rVar5 = this.b.o;
                        rVar5.a(akVar.e().b());
                    } else if (a.e().c() == 1) {
                        rVar13 = this.b.o;
                        rVar14 = this.b.o;
                        rVar13.a(rVar14.k() + 1);
                    } else {
                        rVar12 = this.b.o;
                        rVar12.a(akVar.e().a());
                    }
                    rVar6 = this.b.o;
                    int k2 = rVar6.k();
                    rVar7 = this.b.o;
                    int l3 = k2 - rVar7.l();
                    rVar8 = this.b.o;
                    if (l3 >= rVar8.o()) {
                        rVar9 = this.b.o;
                        rVar10 = this.b.o;
                        int k3 = rVar10.k();
                        rVar11 = this.b.o;
                        rVar9.b((k3 - rVar11.o()) + 1);
                    }
                    if (a.e().c() == 1) {
                        afVar2 = this.b.m;
                        afVar2.b(2);
                    } else {
                        afVar = this.b.m;
                        afVar.b(1);
                    }
                }
                NearbyPbActivity.C = (System.nanoTime() - this.f) / 1000000;
                if (this.c != null) {
                    NearbyPbActivity.D = this.c.a();
                }
            } else if (this.c != null) {
                if (this.d == 3) {
                    if (this.c.c()) {
                        this.b.b(this.c.f());
                        if (this.c.d() == 4 || this.c.d() == 28) {
                            this.b.a();
                            return;
                        }
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
                        builder.setTitle(this.b.getString(R.string.error));
                        builder.setMessage(this.c.f());
                        builder.setPositiveButton(this.b.getString(R.string.retry), new ac(this));
                        builder.setNegativeButton(this.b.getString(R.string.cancel), new ad(this));
                        builder.create().show();
                    }
                } else {
                    this.b.b(this.c.f());
                }
            }
            this.b.u();
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        this.b.n = null;
        b();
        if (this.d == 3) {
            linearLayout = this.b.t;
            linearLayout.invalidate();
        }
    }

    public void a() {
        if (this.c != null) {
            this.c.g();
        }
        b();
        super.cancel(true);
    }

    private void b() {
        ProgressBar progressBar;
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        af afVar5;
        af afVar6;
        af afVar7;
        af afVar8;
        ProgressBar progressBar2;
        progressBar = this.b.q;
        if (progressBar.getVisibility() == 0) {
            progressBar2 = this.b.q;
            progressBar2.setVisibility(8);
        }
        afVar = this.b.m;
        if (afVar.e()) {
            afVar6 = this.b.m;
            afVar6.a(false);
            afVar7 = this.b.m;
            if (afVar7.d()) {
                afVar8 = this.b.m;
                afVar8.notifyDataSetChanged();
            }
        }
        afVar2 = this.b.m;
        if (afVar2.f()) {
            afVar3 = this.b.m;
            afVar3.b(false);
            afVar4 = this.b.m;
            if (afVar4.c()) {
                afVar5 = this.b.m;
                afVar5.notifyDataSetInvalidated();
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f = System.nanoTime();
    }
}
