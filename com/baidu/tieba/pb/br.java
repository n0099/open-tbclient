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
public class br extends AsyncTask {
    ArrayList a;
    final /* synthetic */ PbActivity b;
    private int d;
    private String e;
    private com.baidu.tieba.c.t c = null;
    private volatile long f = 0;

    public br(PbActivity pbActivity, String str, ArrayList arrayList, int i) {
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
    public com.baidu.tieba.a.al doInBackground(Object... objArr) {
        com.baidu.tieba.a.al alVar;
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
            j = PbActivity.ao;
            if (j != 0) {
                com.baidu.tieba.c.t tVar = this.c;
                j6 = PbActivity.ao;
                tVar.a("ctime", String.valueOf(j6));
            }
            j2 = PbActivity.ap;
            if (j2 != 0) {
                com.baidu.tieba.c.t tVar2 = this.c;
                j5 = PbActivity.ap;
                tVar2.a("data_size", String.valueOf(j5));
            }
            i = PbActivity.aq;
            if (i != 0) {
                com.baidu.tieba.c.t tVar3 = this.c;
                i2 = PbActivity.aq;
                tVar3.a("net_error", String.valueOf(i2));
            }
            z = this.b.al;
            if (z) {
                this.b.al = false;
                this.c.a("msg_click", "1");
                com.baidu.tieba.c.t tVar4 = this.c;
                j3 = this.b.am;
                tVar4.a("message_id", String.valueOf(j3));
                j4 = this.b.am;
                com.baidu.tieba.c.af.a("messagePullService", "message_id=", String.valueOf(j4));
            }
            String i3 = this.c.i();
            if (this.c.b()) {
                com.baidu.tieba.a.al alVar2 = new com.baidu.tieba.a.al();
                try {
                    alVar2.a(i3);
                    int size = alVar2.c().size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((com.baidu.tieba.a.an) alVar2.c().get(i4)).b(this.b);
                        ((com.baidu.tieba.a.an) alVar2.c().get(i4)).a((ArrayList) null);
                    }
                    alVar = alVar2;
                } catch (Exception e2) {
                    e = e2;
                    alVar = alVar2;
                    com.baidu.tieba.c.af.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return alVar;
                }
            } else {
                alVar = null;
            }
            try {
                if (this.c.c()) {
                    PbActivity.ao = 0L;
                    PbActivity.ap = 0L;
                    PbActivity.aq = 0;
                } else {
                    PbActivity.aq = 1;
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.tieba.c.af.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
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
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.al alVar) {
        LinearLayout linearLayout;
        ListView listView;
        boolean z;
        boolean z2;
        LinearLayout linearLayout2;
        TranslateAnimation translateAnimation;
        ListView listView2;
        bv bvVar;
        boolean z3;
        boolean z4;
        LinearLayout linearLayout3;
        TranslateAnimation translateAnimation2;
        com.baidu.tieba.b.p pVar;
        com.baidu.tieba.b.p pVar2;
        com.baidu.tieba.b.p pVar3;
        com.baidu.tieba.b.p pVar4;
        com.baidu.tieba.b.p pVar5;
        bv bvVar2;
        bv bvVar3;
        bv bvVar4;
        bv bvVar5;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        b bVar;
        b bVar2;
        bv bvVar6;
        bv bvVar7;
        bv bvVar8;
        ListView listView3;
        bv bvVar9;
        com.baidu.tieba.b.p pVar6;
        com.baidu.tieba.b.p pVar7;
        com.baidu.tieba.b.p pVar8;
        com.baidu.tieba.b.p pVar9;
        com.baidu.tieba.b.p pVar10;
        com.baidu.tieba.b.p pVar11;
        bv bvVar10;
        bv bvVar11;
        bv bvVar12;
        bv bvVar13;
        AlertDialog alertDialog3;
        AlertDialog alertDialog4;
        b bVar3;
        b bVar4;
        bv bvVar14;
        bv bvVar15;
        bv bvVar16;
        bv bvVar17;
        com.baidu.tieba.b.p pVar12;
        com.baidu.tieba.b.p pVar13;
        com.baidu.tieba.b.p pVar14;
        com.baidu.tieba.b.p pVar15;
        com.baidu.tieba.b.p pVar16;
        com.baidu.tieba.b.p pVar17;
        com.baidu.tieba.b.p pVar18;
        com.baidu.tieba.b.p pVar19;
        com.baidu.tieba.b.p pVar20;
        bv bvVar18;
        bv bvVar19;
        bv bvVar20;
        bv bvVar21;
        com.baidu.tieba.b.p pVar21;
        com.baidu.tieba.b.p pVar22;
        com.baidu.tieba.b.p pVar23;
        com.baidu.tieba.b.p pVar24;
        com.baidu.tieba.b.p pVar25;
        com.baidu.tieba.b.p pVar26;
        com.baidu.tieba.b.p pVar27;
        com.baidu.tieba.b.p pVar28;
        com.baidu.tieba.b.p pVar29;
        com.baidu.tieba.b.p pVar30;
        com.baidu.tieba.b.p pVar31;
        ListView listView4;
        com.baidu.tieba.b.p pVar32;
        com.baidu.tieba.b.p pVar33;
        com.baidu.tieba.b.p pVar34;
        com.baidu.tieba.b.p pVar35;
        com.baidu.tieba.b.p pVar36;
        com.baidu.tieba.b.p pVar37;
        com.baidu.tieba.b.p pVar38;
        com.baidu.tieba.b.p pVar39;
        com.baidu.tieba.b.p pVar40;
        com.baidu.tieba.b.p pVar41;
        com.baidu.tieba.b.p pVar42;
        com.baidu.tieba.b.p pVar43;
        com.baidu.tieba.b.p pVar44;
        bv bvVar22;
        bv bvVar23;
        ListView listView5;
        bv bvVar24;
        bv bvVar25;
        com.baidu.tieba.b.p pVar45;
        com.baidu.tieba.b.p pVar46;
        com.baidu.tieba.b.p pVar47;
        com.baidu.tieba.b.p pVar48;
        com.baidu.tieba.b.p pVar49;
        com.baidu.tieba.b.p pVar50;
        com.baidu.tieba.b.p pVar51;
        com.baidu.tieba.b.p pVar52;
        com.baidu.tieba.b.p pVar53;
        com.baidu.tieba.b.p pVar54;
        com.baidu.tieba.b.p pVar55;
        com.baidu.tieba.b.p pVar56;
        com.baidu.tieba.b.p pVar57;
        com.baidu.tieba.b.p pVar58;
        bv bvVar26;
        bv bvVar27;
        bv bvVar28;
        bv bvVar29;
        AlertDialog alertDialog5;
        AlertDialog alertDialog6;
        b bVar5;
        b bVar6;
        bv bvVar30;
        bv bvVar31;
        bv bvVar32;
        bv bvVar33;
        com.baidu.tieba.b.p pVar59;
        com.baidu.tieba.b.p pVar60;
        com.baidu.tieba.b.p pVar61;
        com.baidu.tieba.b.p pVar62;
        AlertDialog alertDialog7;
        AlertDialog alertDialog8;
        AlertDialog alertDialog9;
        try {
            if (alVar != null) {
                pVar = this.b.o;
                com.baidu.tieba.a.al a = pVar.a();
                this.b.af = null;
                pVar2 = this.b.o;
                pVar2.c(alVar.d().c());
                pVar3 = this.b.o;
                pVar3.d(alVar.d().d());
                if (this.d == 3) {
                    pVar52 = this.b.o;
                    pVar52.a(alVar);
                    pVar53 = this.b.o;
                    if (pVar53.c()) {
                        pVar59 = this.b.o;
                        pVar60 = this.b.o;
                        pVar59.a(pVar60.a().d().b());
                        pVar61 = this.b.o;
                        pVar62 = this.b.o;
                        pVar61.b(pVar62.a().d().b());
                    } else {
                        pVar54 = this.b.o;
                        pVar55 = this.b.o;
                        pVar54.a(pVar55.a().d().a());
                        pVar56 = this.b.o;
                        pVar57 = this.b.o;
                        pVar56.b(pVar57.a().d().a());
                    }
                    pVar58 = this.b.o;
                    if (pVar58.c()) {
                        if (alVar.d().c() == 1) {
                            bvVar33 = this.b.m;
                            bvVar33.b(2);
                        } else {
                            bvVar30 = this.b.m;
                            bvVar30.b(1);
                        }
                        if (alVar.d().d() == 1) {
                            bvVar32 = this.b.m;
                            bvVar32.a(2);
                        } else {
                            bvVar31 = this.b.m;
                            bvVar31.a(0);
                        }
                    } else {
                        if (alVar.d().c() == 1) {
                            bvVar29 = this.b.m;
                            bvVar29.b(2);
                        } else {
                            bvVar26 = this.b.m;
                            bvVar26.b(0);
                        }
                        if (alVar.d().d() == 1) {
                            bvVar28 = this.b.m;
                            bvVar28.a(2);
                        } else {
                            bvVar27 = this.b.m;
                            bvVar27.a(1);
                        }
                    }
                    this.b.a(true);
                    alertDialog5 = this.b.x;
                    if (alertDialog5 != null) {
                        alertDialog6 = this.b.x;
                        if (alertDialog6.isShowing()) {
                            bVar5 = this.b.ad;
                            if (bVar5 != null) {
                                bVar6 = this.b.ad;
                                bVar6.notifyDataSetInvalidated();
                            }
                        }
                    }
                } else if (a != null && this.d == 2) {
                    if (a != null) {
                        listView4 = this.b.d;
                        int firstVisiblePosition = listView4.getFirstVisiblePosition();
                        ArrayList c = a.c();
                        ArrayList c2 = alVar.c();
                        int size = firstVisiblePosition + c2.size();
                        c.addAll(0, c2);
                        a.a(alVar.d());
                        a.a(alVar.a());
                        a.a(alVar.b());
                        a.a(alVar.e());
                        pVar32 = this.b.o;
                        if (pVar32.c()) {
                            pVar45 = this.b.o;
                            pVar45.b(alVar.d().b());
                            pVar46 = this.b.o;
                            int k = pVar46.k();
                            pVar47 = this.b.o;
                            int l = k - pVar47.l();
                            pVar48 = this.b.o;
                            if (l >= pVar48.o()) {
                                pVar49 = this.b.o;
                                pVar50 = this.b.o;
                                int l2 = pVar50.l();
                                pVar51 = this.b.o;
                                pVar49.a((l2 + pVar51.o()) - 1);
                            }
                        } else {
                            pVar33 = this.b.o;
                            if (!pVar33.m()) {
                                pVar34 = this.b.o;
                                pVar34.a(alVar.d().b());
                            } else if (a.d().d() == 1) {
                                pVar42 = this.b.o;
                                pVar43 = this.b.o;
                                pVar42.a(pVar43.k() + 1);
                            } else {
                                pVar41 = this.b.o;
                                pVar41.a(alVar.d().a());
                            }
                            pVar35 = this.b.o;
                            int k2 = pVar35.k();
                            pVar36 = this.b.o;
                            int l3 = k2 - pVar36.l();
                            pVar37 = this.b.o;
                            if (l3 >= pVar37.o()) {
                                pVar38 = this.b.o;
                                pVar39 = this.b.o;
                                int k3 = pVar39.k();
                                pVar40 = this.b.o;
                                pVar38.b((k3 - pVar40.o()) + 1);
                            }
                        }
                        pVar44 = this.b.o;
                        if (pVar44.c()) {
                            if (a.d().d() == 1) {
                                bvVar25 = this.b.m;
                                bvVar25.a(2);
                            } else {
                                bvVar24 = this.b.m;
                                bvVar24.a(0);
                            }
                        } else if (a.d().d() == 1) {
                            bvVar23 = this.b.m;
                            bvVar23.a(2);
                        } else {
                            bvVar22 = this.b.m;
                            bvVar22.a(1);
                        }
                        listView5 = this.b.d;
                        listView5.setSelection(size);
                    }
                } else if (a != null && this.d == 1) {
                    a.c().addAll(alVar.c());
                    a.a(alVar.d());
                    a.a(alVar.a());
                    a.a(alVar.b());
                    a.a(alVar.e());
                    pVar12 = this.b.o;
                    if (pVar12.c()) {
                        pVar21 = this.b.o;
                        if (!pVar21.m()) {
                            pVar22 = this.b.o;
                            pVar22.a(alVar.d().b());
                        } else if (a.d().c() == 1) {
                            pVar30 = this.b.o;
                            pVar31 = this.b.o;
                            pVar30.a(pVar31.k() + 1);
                        } else {
                            pVar29 = this.b.o;
                            pVar29.a(alVar.d().a());
                        }
                        pVar23 = this.b.o;
                        int k4 = pVar23.k();
                        pVar24 = this.b.o;
                        int l4 = k4 - pVar24.l();
                        pVar25 = this.b.o;
                        if (l4 >= pVar25.o()) {
                            pVar26 = this.b.o;
                            pVar27 = this.b.o;
                            int k5 = pVar27.k();
                            pVar28 = this.b.o;
                            pVar26.b((k5 - pVar28.o()) + 1);
                        }
                    } else {
                        pVar13 = this.b.o;
                        pVar13.b(alVar.d().b());
                        pVar14 = this.b.o;
                        int k6 = pVar14.k();
                        pVar15 = this.b.o;
                        int l5 = k6 - pVar15.l();
                        pVar16 = this.b.o;
                        if (l5 >= pVar16.o()) {
                            pVar17 = this.b.o;
                            pVar18 = this.b.o;
                            int l6 = pVar18.l();
                            pVar19 = this.b.o;
                            pVar17.a((l6 + pVar19.o()) - 1);
                        }
                    }
                    pVar20 = this.b.o;
                    if (pVar20.c()) {
                        if (a.d().c() == 1) {
                            bvVar21 = this.b.m;
                            bvVar21.b(2);
                        } else {
                            bvVar20 = this.b.m;
                            bvVar20.b(1);
                        }
                    } else if (a.d().c() == 1) {
                        bvVar19 = this.b.m;
                        bvVar19.b(2);
                    } else {
                        bvVar18 = this.b.m;
                        bvVar18.b(0);
                    }
                } else if (this.d == 4 || this.d == 6) {
                    pVar4 = this.b.o;
                    pVar4.a(alVar);
                    pVar5 = this.b.o;
                    if (!pVar5.c()) {
                        this.b.ak = true;
                        if (alVar.d().c() == 1) {
                            bvVar5 = this.b.m;
                            bvVar5.b(2);
                        } else {
                            bvVar2 = this.b.m;
                            bvVar2.b(0);
                        }
                        if (alVar.d().d() == 1) {
                            bvVar4 = this.b.m;
                            bvVar4.a(2);
                        } else {
                            bvVar3 = this.b.m;
                            bvVar3.a(1);
                        }
                    } else {
                        if (alVar.d().c() == 1) {
                            bvVar9 = this.b.m;
                            bvVar9.b(2);
                        } else {
                            bvVar6 = this.b.m;
                            bvVar6.b(1);
                        }
                        if (alVar.d().d() == 1) {
                            bvVar8 = this.b.m;
                            bvVar8.a(2);
                            listView3 = this.b.d;
                            listView3.setSelection(1);
                        } else {
                            bvVar7 = this.b.m;
                            bvVar7.a(0);
                        }
                    }
                    alertDialog = this.b.x;
                    if (alertDialog != null) {
                        alertDialog2 = this.b.x;
                        if (alertDialog2.isShowing()) {
                            bVar = this.b.ad;
                            if (bVar != null) {
                                bVar2 = this.b.ad;
                                bVar2.notifyDataSetInvalidated();
                            }
                        }
                    }
                } else if (this.d == 5) {
                    pVar6 = this.b.o;
                    pVar6.a(alVar);
                    pVar7 = this.b.o;
                    pVar8 = this.b.o;
                    pVar7.a(pVar8.a().d().b());
                    pVar9 = this.b.o;
                    pVar10 = this.b.o;
                    pVar9.b(pVar10.a().d().b());
                    pVar11 = this.b.o;
                    if (pVar11.c()) {
                        if (alVar.d().c() == 1) {
                            bvVar17 = this.b.m;
                            bvVar17.b(2);
                        } else {
                            bvVar14 = this.b.m;
                            bvVar14.b(1);
                        }
                        if (alVar.d().d() == 1) {
                            bvVar16 = this.b.m;
                            bvVar16.a(2);
                        } else {
                            bvVar15 = this.b.m;
                            bvVar15.a(0);
                        }
                    } else {
                        if (alVar.d().c() == 1) {
                            bvVar13 = this.b.m;
                            bvVar13.b(2);
                        } else {
                            bvVar10 = this.b.m;
                            bvVar10.b(0);
                        }
                        if (alVar.d().d() == 1) {
                            bvVar12 = this.b.m;
                            bvVar12.a(2);
                        } else {
                            bvVar11 = this.b.m;
                            bvVar11.a(1);
                        }
                    }
                    alertDialog3 = this.b.x;
                    if (alertDialog3 != null) {
                        alertDialog4 = this.b.x;
                        if (alertDialog4.isShowing()) {
                            bVar3 = this.b.ad;
                            if (bVar3 != null) {
                                bVar4 = this.b.ad;
                                bVar4.notifyDataSetInvalidated();
                            }
                        }
                    }
                }
                PbActivity.ao = (System.nanoTime() - this.f) / 1000000;
                if (this.c != null) {
                    PbActivity.ap = this.c.a();
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
                        builder.setPositiveButton(this.b.getString(R.string.retry), new bs(this));
                        builder.setNegativeButton(this.b.getString(R.string.cancel), new bt(this));
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
            this.b.C();
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        this.b.n = null;
        b();
        if (this.d == 5) {
            listView2 = this.b.d;
            listView2.setSelection(0);
            bvVar = this.b.m;
            bvVar.notifyDataSetInvalidated();
            z3 = this.b.av;
            if (!z3) {
                z4 = this.b.au;
                if (!z4) {
                    linearLayout3 = this.b.B;
                    translateAnimation2 = this.b.as;
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
            z = this.b.av;
            if (!z) {
                z2 = this.b.au;
                if (!z2) {
                    linearLayout2 = this.b.B;
                    translateAnimation = this.b.as;
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
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bv bvVar4;
        bv bvVar5;
        bv bvVar6;
        bv bvVar7;
        bv bvVar8;
        ProgressBar progressBar2;
        progressBar = this.b.r;
        if (progressBar.getVisibility() == 0) {
            progressBar2 = this.b.r;
            progressBar2.setVisibility(8);
        }
        bvVar = this.b.m;
        if (bvVar.g()) {
            bvVar6 = this.b.m;
            bvVar6.a(false);
            bvVar7 = this.b.m;
            if (bvVar7.e()) {
                bvVar8 = this.b.m;
                bvVar8.notifyDataSetChanged();
            }
        }
        bvVar2 = this.b.m;
        if (bvVar2.h()) {
            bvVar3 = this.b.m;
            bvVar3.b(false);
            bvVar4 = this.b.m;
            if (bvVar4.c()) {
                bvVar5 = this.b.m;
                bvVar5.notifyDataSetInvalidated();
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f = System.nanoTime();
    }
}
