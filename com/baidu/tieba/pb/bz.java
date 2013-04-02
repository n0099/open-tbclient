package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz extends AsyncTask {
    ArrayList a;
    final /* synthetic */ PbActivity b;
    private int d;
    private String e;
    private com.baidu.tieba.c.t c = null;
    private volatile long f = 0;

    public bz(PbActivity pbActivity, String str, ArrayList arrayList, int i) {
        this.b = pbActivity;
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
        boolean z;
        long j3;
        long j4;
        int i2;
        long j5;
        long j6;
        try {
            this.c = new com.baidu.tieba.c.t(this.e);
            this.c.a(this.a);
            j = PbActivity.aq;
            if (j != 0) {
                com.baidu.tieba.c.t tVar = this.c;
                j6 = PbActivity.aq;
                tVar.a("ctime", String.valueOf(j6));
            }
            j2 = PbActivity.ar;
            if (j2 != 0) {
                com.baidu.tieba.c.t tVar2 = this.c;
                j5 = PbActivity.ar;
                tVar2.a("data_size", String.valueOf(j5));
            }
            i = PbActivity.as;
            if (i != 0) {
                com.baidu.tieba.c.t tVar3 = this.c;
                i2 = PbActivity.as;
                tVar3.a("net_error", String.valueOf(i2));
            }
            z = this.b.an;
            if (z) {
                this.b.an = false;
                this.c.a("msg_click", "1");
                com.baidu.tieba.c.t tVar4 = this.c;
                j3 = this.b.ao;
                tVar4.a("message_id", String.valueOf(j3));
                j4 = this.b.ao;
                com.baidu.tieba.c.ag.a("messagePullService", "message_id=", String.valueOf(j4));
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
                    PbActivity.aq = 0L;
                    PbActivity.ar = 0L;
                    PbActivity.as = 0;
                } else {
                    PbActivity.as = 1;
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
        ListView listView;
        boolean z;
        boolean z2;
        LinearLayout linearLayout2;
        TranslateAnimation translateAnimation;
        ListView listView2;
        cd cdVar;
        boolean z3;
        boolean z4;
        LinearLayout linearLayout3;
        TranslateAnimation translateAnimation2;
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        com.baidu.tieba.b.r rVar3;
        com.baidu.tieba.b.r rVar4;
        com.baidu.tieba.b.r rVar5;
        com.baidu.tieba.b.r rVar6;
        com.baidu.tieba.b.r rVar7;
        cd cdVar2;
        cd cdVar3;
        cd cdVar4;
        cd cdVar5;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        b bVar;
        b bVar2;
        cd cdVar6;
        cd cdVar7;
        cd cdVar8;
        ListView listView3;
        cd cdVar9;
        com.baidu.tieba.b.r rVar8;
        com.baidu.tieba.b.r rVar9;
        com.baidu.tieba.b.r rVar10;
        com.baidu.tieba.b.r rVar11;
        com.baidu.tieba.b.r rVar12;
        com.baidu.tieba.b.r rVar13;
        com.baidu.tieba.b.r rVar14;
        com.baidu.tieba.b.r rVar15;
        cd cdVar10;
        cd cdVar11;
        cd cdVar12;
        cd cdVar13;
        AlertDialog alertDialog3;
        AlertDialog alertDialog4;
        b bVar3;
        b bVar4;
        cd cdVar14;
        cd cdVar15;
        cd cdVar16;
        cd cdVar17;
        com.baidu.tieba.b.r rVar16;
        com.baidu.tieba.b.r rVar17;
        com.baidu.tieba.b.r rVar18;
        com.baidu.tieba.b.r rVar19;
        com.baidu.tieba.b.r rVar20;
        com.baidu.tieba.b.r rVar21;
        com.baidu.tieba.b.r rVar22;
        com.baidu.tieba.b.r rVar23;
        com.baidu.tieba.b.r rVar24;
        cd cdVar18;
        cd cdVar19;
        cd cdVar20;
        cd cdVar21;
        com.baidu.tieba.b.r rVar25;
        com.baidu.tieba.b.r rVar26;
        com.baidu.tieba.b.r rVar27;
        com.baidu.tieba.b.r rVar28;
        com.baidu.tieba.b.r rVar29;
        com.baidu.tieba.b.r rVar30;
        com.baidu.tieba.b.r rVar31;
        com.baidu.tieba.b.r rVar32;
        com.baidu.tieba.b.r rVar33;
        com.baidu.tieba.b.r rVar34;
        com.baidu.tieba.b.r rVar35;
        ListView listView4;
        com.baidu.tieba.b.r rVar36;
        com.baidu.tieba.b.r rVar37;
        com.baidu.tieba.b.r rVar38;
        com.baidu.tieba.b.r rVar39;
        com.baidu.tieba.b.r rVar40;
        com.baidu.tieba.b.r rVar41;
        com.baidu.tieba.b.r rVar42;
        com.baidu.tieba.b.r rVar43;
        com.baidu.tieba.b.r rVar44;
        com.baidu.tieba.b.r rVar45;
        com.baidu.tieba.b.r rVar46;
        com.baidu.tieba.b.r rVar47;
        com.baidu.tieba.b.r rVar48;
        cd cdVar22;
        cd cdVar23;
        ListView listView5;
        cd cdVar24;
        cd cdVar25;
        com.baidu.tieba.b.r rVar49;
        com.baidu.tieba.b.r rVar50;
        com.baidu.tieba.b.r rVar51;
        com.baidu.tieba.b.r rVar52;
        com.baidu.tieba.b.r rVar53;
        com.baidu.tieba.b.r rVar54;
        com.baidu.tieba.b.r rVar55;
        com.baidu.tieba.b.r rVar56;
        com.baidu.tieba.b.r rVar57;
        com.baidu.tieba.b.r rVar58;
        com.baidu.tieba.b.r rVar59;
        com.baidu.tieba.b.r rVar60;
        com.baidu.tieba.b.r rVar61;
        com.baidu.tieba.b.r rVar62;
        cd cdVar26;
        cd cdVar27;
        cd cdVar28;
        cd cdVar29;
        AlertDialog alertDialog5;
        AlertDialog alertDialog6;
        b bVar5;
        b bVar6;
        cd cdVar30;
        cd cdVar31;
        cd cdVar32;
        cd cdVar33;
        com.baidu.tieba.b.r rVar63;
        com.baidu.tieba.b.r rVar64;
        com.baidu.tieba.b.r rVar65;
        com.baidu.tieba.b.r rVar66;
        AlertDialog alertDialog7;
        AlertDialog alertDialog8;
        AlertDialog alertDialog9;
        try {
            if (akVar != null) {
                rVar = this.b.o;
                com.baidu.tieba.a.ak a = rVar.a();
                this.b.ai = null;
                rVar2 = this.b.o;
                rVar2.c(akVar.e().c());
                rVar3 = this.b.o;
                rVar3.d(akVar.e().d());
                rVar4 = this.b.o;
                rVar4.i(akVar.g());
                rVar5 = this.b.o;
                rVar5.a(akVar.h());
                if (this.d == 3) {
                    rVar56 = this.b.o;
                    rVar56.a(akVar);
                    rVar57 = this.b.o;
                    if (rVar57.c()) {
                        rVar63 = this.b.o;
                        rVar64 = this.b.o;
                        rVar63.a(rVar64.a().e().b());
                        rVar65 = this.b.o;
                        rVar66 = this.b.o;
                        rVar65.b(rVar66.a().e().b());
                    } else {
                        rVar58 = this.b.o;
                        rVar59 = this.b.o;
                        rVar58.a(rVar59.a().e().a());
                        rVar60 = this.b.o;
                        rVar61 = this.b.o;
                        rVar60.b(rVar61.a().e().a());
                    }
                    rVar62 = this.b.o;
                    if (rVar62.c()) {
                        if (akVar.e().c() == 1) {
                            cdVar33 = this.b.m;
                            cdVar33.b(2);
                        } else {
                            cdVar30 = this.b.m;
                            cdVar30.b(1);
                        }
                        if (akVar.e().d() == 1) {
                            cdVar32 = this.b.m;
                            cdVar32.a(2);
                        } else {
                            cdVar31 = this.b.m;
                            cdVar31.a(0);
                        }
                    } else {
                        if (akVar.e().c() == 1) {
                            cdVar29 = this.b.m;
                            cdVar29.b(2);
                        } else {
                            cdVar26 = this.b.m;
                            cdVar26.b(0);
                        }
                        if (akVar.e().d() == 1) {
                            cdVar28 = this.b.m;
                            cdVar28.a(2);
                        } else {
                            cdVar27 = this.b.m;
                            cdVar27.a(1);
                        }
                    }
                    this.b.a(true);
                    alertDialog5 = this.b.x;
                    if (alertDialog5 != null) {
                        alertDialog6 = this.b.x;
                        if (alertDialog6.isShowing()) {
                            bVar5 = this.b.ag;
                            if (bVar5 != null) {
                                bVar6 = this.b.ag;
                                bVar6.notifyDataSetInvalidated();
                            }
                        }
                    }
                } else if (a != null && this.d == 2) {
                    if (a != null) {
                        listView4 = this.b.d;
                        int firstVisiblePosition = listView4.getFirstVisiblePosition();
                        ArrayList d = a.d();
                        ArrayList d2 = akVar.d();
                        int size = firstVisiblePosition + d2.size();
                        d.addAll(0, d2);
                        a.a(akVar.e());
                        a.a(akVar.a());
                        a.a(akVar.b());
                        a.a(akVar.f());
                        rVar36 = this.b.o;
                        if (rVar36.c()) {
                            rVar49 = this.b.o;
                            rVar49.b(akVar.e().b());
                            rVar50 = this.b.o;
                            int k = rVar50.k();
                            rVar51 = this.b.o;
                            int l = k - rVar51.l();
                            rVar52 = this.b.o;
                            if (l >= rVar52.o()) {
                                rVar53 = this.b.o;
                                rVar54 = this.b.o;
                                int l2 = rVar54.l();
                                rVar55 = this.b.o;
                                rVar53.a((l2 + rVar55.o()) - 1);
                            }
                        } else {
                            rVar37 = this.b.o;
                            if (!rVar37.m()) {
                                rVar38 = this.b.o;
                                rVar38.a(akVar.e().b());
                            } else if (a.e().d() == 1) {
                                rVar46 = this.b.o;
                                rVar47 = this.b.o;
                                rVar46.a(rVar47.k() + 1);
                            } else {
                                rVar45 = this.b.o;
                                rVar45.a(akVar.e().a());
                            }
                            rVar39 = this.b.o;
                            int k2 = rVar39.k();
                            rVar40 = this.b.o;
                            int l3 = k2 - rVar40.l();
                            rVar41 = this.b.o;
                            if (l3 >= rVar41.o()) {
                                rVar42 = this.b.o;
                                rVar43 = this.b.o;
                                int k3 = rVar43.k();
                                rVar44 = this.b.o;
                                rVar42.b((k3 - rVar44.o()) + 1);
                            }
                        }
                        rVar48 = this.b.o;
                        if (rVar48.c()) {
                            if (a.e().d() == 1) {
                                cdVar25 = this.b.m;
                                cdVar25.a(2);
                            } else {
                                cdVar24 = this.b.m;
                                cdVar24.a(0);
                            }
                        } else if (a.e().d() == 1) {
                            cdVar23 = this.b.m;
                            cdVar23.a(2);
                        } else {
                            cdVar22 = this.b.m;
                            cdVar22.a(1);
                        }
                        listView5 = this.b.d;
                        listView5.setSelection(size);
                    }
                } else if (a != null && this.d == 1) {
                    a.d().addAll(akVar.d());
                    a.a(akVar.e());
                    a.a(akVar.a());
                    a.a(akVar.b());
                    a.a(akVar.f());
                    rVar16 = this.b.o;
                    if (rVar16.c()) {
                        rVar25 = this.b.o;
                        if (!rVar25.m()) {
                            rVar26 = this.b.o;
                            rVar26.a(akVar.e().b());
                        } else if (a.e().c() == 1) {
                            rVar34 = this.b.o;
                            rVar35 = this.b.o;
                            rVar34.a(rVar35.k() + 1);
                        } else {
                            rVar33 = this.b.o;
                            rVar33.a(akVar.e().a());
                        }
                        rVar27 = this.b.o;
                        int k4 = rVar27.k();
                        rVar28 = this.b.o;
                        int l4 = k4 - rVar28.l();
                        rVar29 = this.b.o;
                        if (l4 >= rVar29.o()) {
                            rVar30 = this.b.o;
                            rVar31 = this.b.o;
                            int k5 = rVar31.k();
                            rVar32 = this.b.o;
                            rVar30.b((k5 - rVar32.o()) + 1);
                        }
                    } else {
                        rVar17 = this.b.o;
                        rVar17.b(akVar.e().b());
                        rVar18 = this.b.o;
                        int k6 = rVar18.k();
                        rVar19 = this.b.o;
                        int l5 = k6 - rVar19.l();
                        rVar20 = this.b.o;
                        if (l5 >= rVar20.o()) {
                            rVar21 = this.b.o;
                            rVar22 = this.b.o;
                            int l6 = rVar22.l();
                            rVar23 = this.b.o;
                            rVar21.a((l6 + rVar23.o()) - 1);
                        }
                    }
                    rVar24 = this.b.o;
                    if (rVar24.c()) {
                        if (a.e().c() == 1) {
                            cdVar21 = this.b.m;
                            cdVar21.b(2);
                        } else {
                            cdVar20 = this.b.m;
                            cdVar20.b(1);
                        }
                    } else if (a.e().c() == 1) {
                        cdVar19 = this.b.m;
                        cdVar19.b(2);
                    } else {
                        cdVar18 = this.b.m;
                        cdVar18.b(0);
                    }
                } else if (this.d == 4 || this.d == 6) {
                    rVar6 = this.b.o;
                    rVar6.a(akVar);
                    if (this.d == 4) {
                        rVar8 = this.b.o;
                        rVar8.b(akVar.e().b());
                        rVar9 = this.b.o;
                        rVar9.a(akVar.e().b());
                    }
                    rVar7 = this.b.o;
                    if (!rVar7.c()) {
                        this.b.am = true;
                        if (akVar.e().c() == 1) {
                            cdVar5 = this.b.m;
                            cdVar5.b(2);
                        } else {
                            cdVar2 = this.b.m;
                            cdVar2.b(0);
                        }
                        if (akVar.e().d() == 1) {
                            cdVar4 = this.b.m;
                            cdVar4.a(2);
                        } else {
                            cdVar3 = this.b.m;
                            cdVar3.a(1);
                        }
                    } else {
                        if (akVar.e().c() == 1) {
                            cdVar9 = this.b.m;
                            cdVar9.b(2);
                        } else {
                            cdVar6 = this.b.m;
                            cdVar6.b(1);
                        }
                        if (akVar.e().d() == 1) {
                            cdVar8 = this.b.m;
                            cdVar8.a(2);
                            listView3 = this.b.d;
                            listView3.setSelection(1);
                        } else {
                            cdVar7 = this.b.m;
                            cdVar7.a(0);
                        }
                    }
                    alertDialog = this.b.x;
                    if (alertDialog != null) {
                        alertDialog2 = this.b.x;
                        if (alertDialog2.isShowing()) {
                            bVar = this.b.ag;
                            if (bVar != null) {
                                bVar2 = this.b.ag;
                                bVar2.notifyDataSetInvalidated();
                            }
                        }
                    }
                } else if (this.d == 5) {
                    rVar10 = this.b.o;
                    rVar10.a(akVar);
                    rVar11 = this.b.o;
                    rVar12 = this.b.o;
                    rVar11.a(rVar12.a().e().b());
                    rVar13 = this.b.o;
                    rVar14 = this.b.o;
                    rVar13.b(rVar14.a().e().b());
                    rVar15 = this.b.o;
                    if (rVar15.c()) {
                        if (akVar.e().c() == 1) {
                            cdVar17 = this.b.m;
                            cdVar17.b(2);
                        } else {
                            cdVar14 = this.b.m;
                            cdVar14.b(1);
                        }
                        if (akVar.e().d() == 1) {
                            cdVar16 = this.b.m;
                            cdVar16.a(2);
                        } else {
                            cdVar15 = this.b.m;
                            cdVar15.a(0);
                        }
                    } else {
                        if (akVar.e().c() == 1) {
                            cdVar13 = this.b.m;
                            cdVar13.b(2);
                        } else {
                            cdVar10 = this.b.m;
                            cdVar10.b(0);
                        }
                        if (akVar.e().d() == 1) {
                            cdVar12 = this.b.m;
                            cdVar12.a(2);
                        } else {
                            cdVar11 = this.b.m;
                            cdVar11.a(1);
                        }
                    }
                    alertDialog3 = this.b.x;
                    if (alertDialog3 != null) {
                        alertDialog4 = this.b.x;
                        if (alertDialog4.isShowing()) {
                            bVar3 = this.b.ag;
                            if (bVar3 != null) {
                                bVar4 = this.b.ag;
                                bVar4.notifyDataSetInvalidated();
                            }
                        }
                    }
                }
                PbActivity.aq = (System.nanoTime() - this.f) / 1000000;
                if (this.c != null) {
                    PbActivity.ar = this.c.a();
                }
            } else if (this.c != null) {
                if (this.d == 3 || this.d == 4 || this.d == 6) {
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
                        builder.setPositiveButton(this.b.getString(R.string.retry), new ca(this));
                        builder.setNegativeButton(this.b.getString(R.string.cancel), new cb(this));
                        alertDialog7 = this.b.x;
                        if (alertDialog7 != null) {
                            alertDialog8 = this.b.x;
                            if (alertDialog8.isShowing()) {
                                alertDialog9 = this.b.x;
                                alertDialog9.dismiss();
                            }
                        }
                        builder.create().show();
                    }
                } else {
                    this.b.b(this.c.f());
                }
            }
            this.b.E();
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        this.b.n = null;
        b();
        if (this.d == 5) {
            listView2 = this.b.d;
            listView2.setSelection(0);
            cdVar = this.b.m;
            cdVar.notifyDataSetInvalidated();
            z3 = this.b.ax;
            if (!z3) {
                z4 = this.b.aw;
                if (!z4) {
                    linearLayout3 = this.b.B;
                    translateAnimation2 = this.b.au;
                    linearLayout3.startAnimation(translateAnimation2);
                }
            }
        }
        if (this.d == 3 || this.d == 4 || this.d == 6) {
            linearLayout = this.b.B;
            linearLayout.invalidate();
        }
        listView = this.b.d;
        if (listView.getFirstVisiblePosition() == 0) {
            z = this.b.ax;
            if (!z) {
                z2 = this.b.aw;
                if (!z2) {
                    linearLayout2 = this.b.B;
                    translateAnimation = this.b.au;
                    linearLayout2.startAnimation(translateAnimation);
                }
            }
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
        cd cdVar;
        cd cdVar2;
        cd cdVar3;
        cd cdVar4;
        cd cdVar5;
        cd cdVar6;
        cd cdVar7;
        cd cdVar8;
        ProgressBar progressBar2;
        progressBar = this.b.r;
        if (progressBar.getVisibility() == 0) {
            progressBar2 = this.b.r;
            progressBar2.setVisibility(8);
        }
        cdVar = this.b.m;
        if (cdVar.g()) {
            cdVar6 = this.b.m;
            cdVar6.a(false);
            cdVar7 = this.b.m;
            if (cdVar7.e()) {
                cdVar8 = this.b.m;
                cdVar8.notifyDataSetChanged();
            }
        }
        cdVar2 = this.b.m;
        if (cdVar2.h()) {
            cdVar3 = this.b.m;
            cdVar3.b(false);
            cdVar4 = this.b.m;
            if (cdVar4.c()) {
                cdVar5 = this.b.m;
                cdVar5.notifyDataSetInvalidated();
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f = System.nanoTime();
    }
}
