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
    public com.baidu.tieba.a.ai doInBackground(Object... objArr) {
        com.baidu.tieba.a.ai aiVar;
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
                com.baidu.tieba.a.ai aiVar2 = new com.baidu.tieba.a.ai();
                try {
                    aiVar2.a(i3);
                    int size = aiVar2.d().size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((com.baidu.tieba.a.al) aiVar2.d().get(i4)).b(this.b);
                        ((com.baidu.tieba.a.al) aiVar2.d().get(i4)).a((ArrayList) null);
                    }
                    aiVar = aiVar2;
                } catch (Exception e2) {
                    e = e2;
                    aiVar = aiVar2;
                    com.baidu.tieba.c.ag.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return aiVar;
                }
            } else {
                aiVar = null;
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
                return aiVar;
            }
        } catch (Exception e4) {
            aiVar = null;
            e = e4;
        }
        return aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.ai aiVar) {
        LinearLayout linearLayout;
        com.baidu.tieba.b.q qVar;
        com.baidu.tieba.b.q qVar2;
        com.baidu.tieba.b.q qVar3;
        com.baidu.tieba.b.q qVar4;
        com.baidu.tieba.b.q qVar5;
        com.baidu.tieba.b.q qVar6;
        com.baidu.tieba.b.q qVar7;
        com.baidu.tieba.b.q qVar8;
        af afVar;
        af afVar2;
        com.baidu.tieba.b.q qVar9;
        com.baidu.tieba.b.q qVar10;
        com.baidu.tieba.b.q qVar11;
        com.baidu.tieba.b.q qVar12;
        com.baidu.tieba.b.q qVar13;
        com.baidu.tieba.b.q qVar14;
        ListView listView;
        com.baidu.tieba.b.q qVar15;
        com.baidu.tieba.b.q qVar16;
        com.baidu.tieba.b.q qVar17;
        com.baidu.tieba.b.q qVar18;
        af afVar3;
        ListView listView2;
        af afVar4;
        com.baidu.tieba.b.q qVar19;
        com.baidu.tieba.b.q qVar20;
        com.baidu.tieba.b.q qVar21;
        com.baidu.tieba.b.q qVar22;
        com.baidu.tieba.b.q qVar23;
        com.baidu.tieba.b.q qVar24;
        com.baidu.tieba.b.q qVar25;
        com.baidu.tieba.b.q qVar26;
        af afVar5;
        af afVar6;
        af afVar7;
        af afVar8;
        try {
            if (aiVar != null) {
                qVar = this.b.o;
                com.baidu.tieba.a.ai a = qVar.a();
                this.b.v = null;
                qVar2 = this.b.o;
                qVar2.c(aiVar.e().c());
                qVar3 = this.b.o;
                qVar3.d(aiVar.e().d());
                if (this.d == 3) {
                    qVar22 = this.b.o;
                    qVar22.a(aiVar);
                    qVar23 = this.b.o;
                    qVar24 = this.b.o;
                    qVar23.a(qVar24.a().e().b());
                    qVar25 = this.b.o;
                    qVar26 = this.b.o;
                    qVar25.b(qVar26.a().e().b());
                    if (aiVar.e().c() == 1) {
                        afVar8 = this.b.m;
                        afVar8.b(2);
                    } else {
                        afVar5 = this.b.m;
                        afVar5.b(1);
                    }
                    if (aiVar.e().d() == 1) {
                        afVar7 = this.b.m;
                        afVar7.a(2);
                    } else {
                        afVar6 = this.b.m;
                        afVar6.a(0);
                    }
                    aiVar.g();
                } else if (a != null && this.d == 2) {
                    listView = this.b.d;
                    int firstVisiblePosition = listView.getFirstVisiblePosition();
                    ArrayList d = a.d();
                    ArrayList d2 = aiVar.d();
                    int size = firstVisiblePosition + d2.size();
                    d.addAll(0, d2);
                    a.a(aiVar.e());
                    a.a(aiVar.a());
                    a.a(aiVar.b());
                    a.a(aiVar.f());
                    qVar15 = this.b.o;
                    qVar15.b(aiVar.e().b());
                    qVar16 = this.b.o;
                    int k = qVar16.k();
                    qVar17 = this.b.o;
                    int l = k - qVar17.l();
                    qVar18 = this.b.o;
                    if (l >= qVar18.o()) {
                        qVar19 = this.b.o;
                        qVar20 = this.b.o;
                        int l2 = qVar20.l();
                        qVar21 = this.b.o;
                        qVar19.a((l2 + qVar21.o()) - 1);
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
                    a.d().addAll(aiVar.d());
                    a.a(aiVar.e());
                    a.a(aiVar.a());
                    a.a(aiVar.b());
                    a.a(aiVar.f());
                    qVar4 = this.b.o;
                    if (!qVar4.m()) {
                        qVar5 = this.b.o;
                        qVar5.a(aiVar.e().b());
                    } else if (a.e().c() == 1) {
                        qVar13 = this.b.o;
                        qVar14 = this.b.o;
                        qVar13.a(qVar14.k() + 1);
                    } else {
                        qVar12 = this.b.o;
                        qVar12.a(aiVar.e().a());
                    }
                    qVar6 = this.b.o;
                    int k2 = qVar6.k();
                    qVar7 = this.b.o;
                    int l3 = k2 - qVar7.l();
                    qVar8 = this.b.o;
                    if (l3 >= qVar8.o()) {
                        qVar9 = this.b.o;
                        qVar10 = this.b.o;
                        int k3 = qVar10.k();
                        qVar11 = this.b.o;
                        qVar9.b((k3 - qVar11.o()) + 1);
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
