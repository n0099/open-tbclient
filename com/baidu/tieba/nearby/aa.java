package com.baidu.tieba.nearby;

import android.app.AlertDialog;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f1123a;
    final /* synthetic */ NearbyPbActivity b;
    private int d;
    private String e;
    private com.baidu.tieba.util.r c = null;
    private volatile long f = 0;

    public aa(NearbyPbActivity nearbyPbActivity, String str, ArrayList arrayList, int i) {
        this.b = nearbyPbActivity;
        this.d = 3;
        this.e = null;
        this.f1123a = null;
        this.e = str;
        this.f1123a = arrayList;
        this.d = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.aj a(Object... objArr) {
        com.baidu.tieba.data.aj ajVar;
        Exception e;
        long j;
        long j2;
        int i;
        int i2;
        long j3;
        long j4;
        try {
            this.c = new com.baidu.tieba.util.r(this.e);
            this.c.a(this.f1123a);
            j = NearbyPbActivity.B;
            if (j != 0) {
                com.baidu.tieba.util.r rVar = this.c;
                j4 = NearbyPbActivity.B;
                rVar.a("ctime", String.valueOf(j4));
            }
            j2 = NearbyPbActivity.C;
            if (j2 != 0) {
                com.baidu.tieba.util.r rVar2 = this.c;
                j3 = NearbyPbActivity.C;
                rVar2.a("data_size", String.valueOf(j3));
            }
            i = NearbyPbActivity.D;
            if (i != 0) {
                com.baidu.tieba.util.r rVar3 = this.c;
                i2 = NearbyPbActivity.D;
                rVar3.a("net_error", String.valueOf(i2));
            }
            String j5 = this.c.j();
            if (this.c.c()) {
                com.baidu.tieba.data.aj ajVar2 = new com.baidu.tieba.data.aj();
                try {
                    ajVar2.b(j5);
                    int size = ajVar2.d().size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((com.baidu.tieba.data.an) ajVar2.d().get(i3)).c(this.b);
                        ((com.baidu.tieba.data.an) ajVar2.d().get(i3)).a((ArrayList) null);
                    }
                    ajVar = ajVar2;
                } catch (Exception e2) {
                    e = e2;
                    ajVar = ajVar2;
                    com.baidu.tieba.util.z.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return ajVar;
                }
            } else {
                ajVar = null;
            }
            try {
                if (this.c.d()) {
                    NearbyPbActivity.B = 0L;
                    NearbyPbActivity.C = 0L;
                    NearbyPbActivity.D = 0;
                } else {
                    NearbyPbActivity.D = 1;
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.tieba.util.z.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
                return ajVar;
            }
        } catch (Exception e4) {
            ajVar = null;
            e = e4;
        }
        return ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.aj ajVar) {
        LinearLayout linearLayout;
        com.baidu.tieba.model.bg bgVar;
        com.baidu.tieba.model.bg bgVar2;
        com.baidu.tieba.model.bg bgVar3;
        com.baidu.tieba.model.bg bgVar4;
        com.baidu.tieba.model.bg bgVar5;
        com.baidu.tieba.model.bg bgVar6;
        com.baidu.tieba.model.bg bgVar7;
        com.baidu.tieba.model.bg bgVar8;
        ae aeVar;
        ae aeVar2;
        com.baidu.tieba.model.bg bgVar9;
        com.baidu.tieba.model.bg bgVar10;
        com.baidu.tieba.model.bg bgVar11;
        com.baidu.tieba.model.bg bgVar12;
        com.baidu.tieba.model.bg bgVar13;
        com.baidu.tieba.model.bg bgVar14;
        ListView listView;
        com.baidu.tieba.model.bg bgVar15;
        com.baidu.tieba.model.bg bgVar16;
        com.baidu.tieba.model.bg bgVar17;
        com.baidu.tieba.model.bg bgVar18;
        ae aeVar3;
        ListView listView2;
        ae aeVar4;
        com.baidu.tieba.model.bg bgVar19;
        com.baidu.tieba.model.bg bgVar20;
        com.baidu.tieba.model.bg bgVar21;
        com.baidu.tieba.model.bg bgVar22;
        com.baidu.tieba.model.bg bgVar23;
        com.baidu.tieba.model.bg bgVar24;
        com.baidu.tieba.model.bg bgVar25;
        com.baidu.tieba.model.bg bgVar26;
        ae aeVar5;
        ae aeVar6;
        ae aeVar7;
        ae aeVar8;
        try {
            if (ajVar != null) {
                bgVar = this.b.n;
                com.baidu.tieba.data.aj a2 = bgVar.a();
                this.b.u = null;
                bgVar2 = this.b.n;
                bgVar2.c(ajVar.e().f());
                bgVar3 = this.b.n;
                bgVar3.d(ajVar.e().g());
                if (this.d == 3) {
                    bgVar22 = this.b.n;
                    bgVar22.a(ajVar);
                    bgVar23 = this.b.n;
                    bgVar24 = this.b.n;
                    bgVar23.a(bgVar24.a().e().d());
                    bgVar25 = this.b.n;
                    bgVar26 = this.b.n;
                    bgVar25.b(bgVar26.a().e().d());
                    if (ajVar.e().f() == 1) {
                        aeVar8 = this.b.l;
                        aeVar8.b(2);
                    } else {
                        aeVar5 = this.b.l;
                        aeVar5.b(1);
                    }
                    if (ajVar.e().g() == 1) {
                        aeVar7 = this.b.l;
                        aeVar7.a(2);
                    } else {
                        aeVar6 = this.b.l;
                        aeVar6.a(0);
                    }
                    ajVar.i();
                } else if (a2 != null && this.d == 2) {
                    listView = this.b.b;
                    int firstVisiblePosition = listView.getFirstVisiblePosition();
                    ArrayList d = a2.d();
                    ArrayList d2 = ajVar.d();
                    int size = firstVisiblePosition + d2.size();
                    d.addAll(0, d2);
                    a2.a(ajVar.e(), 0);
                    a2.a(ajVar.a());
                    a2.a(ajVar.b());
                    a2.a(ajVar.f());
                    bgVar15 = this.b.n;
                    bgVar15.b(ajVar.e().d());
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
                    if (a2.e().g() == 1) {
                        aeVar4 = this.b.l;
                        aeVar4.a(2);
                    } else {
                        aeVar3 = this.b.l;
                        aeVar3.a(0);
                    }
                    listView2 = this.b.b;
                    listView2.setSelection(size);
                } else if (a2 != null && this.d == 1) {
                    a2.d().addAll(ajVar.d());
                    a2.a(ajVar.e(), 0);
                    a2.a(ajVar.a());
                    a2.a(ajVar.b());
                    a2.a(ajVar.f());
                    bgVar4 = this.b.n;
                    if (!bgVar4.e()) {
                        bgVar5 = this.b.n;
                        bgVar5.a(ajVar.e().d());
                    } else if (a2.e().f() == 1) {
                        bgVar13 = this.b.n;
                        bgVar14 = this.b.n;
                        bgVar13.a(bgVar14.c() + 1);
                    } else {
                        bgVar12 = this.b.n;
                        bgVar12.a(ajVar.e().a());
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
                    if (a2.e().f() == 1) {
                        aeVar2 = this.b.l;
                        aeVar2.b(2);
                    } else {
                        aeVar = this.b.l;
                        aeVar.b(1);
                    }
                }
                NearbyPbActivity.B = (System.nanoTime() - this.f) / 1000000;
                if (this.c != null) {
                    NearbyPbActivity.C = this.c.b();
                }
            } else if (this.c != null) {
                if (this.d == 3) {
                    if (this.c.d()) {
                        this.b.a(this.c.g());
                        if (this.c.e() == 4 || this.c.e() == 28) {
                            this.b.f();
                            return;
                        }
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
                        builder.setTitle(this.b.getString(R.string.error));
                        builder.setMessage(this.c.g());
                        builder.setPositiveButton(this.b.getString(R.string.retry), new ab(this));
                        builder.setNegativeButton(this.b.getString(R.string.cancel), new ac(this));
                        builder.create().show();
                    }
                } else {
                    this.b.a(this.c.g());
                }
            }
            this.b.v();
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        this.b.m = null;
        e();
        if (this.d == 3) {
            linearLayout = this.b.s;
            linearLayout.invalidate();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.c != null) {
            this.c.h();
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
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
        this.f = System.nanoTime();
    }
}
