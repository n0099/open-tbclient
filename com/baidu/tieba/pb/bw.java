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
public class bw extends AsyncTask {
    ArrayList a;
    final /* synthetic */ PbActivity b;
    private int d;
    private String e;
    private com.baidu.tieba.c.t c = null;
    private volatile long f = 0;

    public bw(PbActivity pbActivity, String str, ArrayList arrayList, int i) {
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
    public com.baidu.tieba.a.ai doInBackground(Object... objArr) {
        com.baidu.tieba.a.ai aiVar;
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
            j = PbActivity.ap;
            if (j != 0) {
                com.baidu.tieba.c.t tVar = this.c;
                j6 = PbActivity.ap;
                tVar.a("ctime", String.valueOf(j6));
            }
            j2 = PbActivity.aq;
            if (j2 != 0) {
                com.baidu.tieba.c.t tVar2 = this.c;
                j5 = PbActivity.aq;
                tVar2.a("data_size", String.valueOf(j5));
            }
            i = PbActivity.ar;
            if (i != 0) {
                com.baidu.tieba.c.t tVar3 = this.c;
                i2 = PbActivity.ar;
                tVar3.a("net_error", String.valueOf(i2));
            }
            z = this.b.am;
            if (z) {
                this.b.am = false;
                this.c.a("msg_click", "1");
                com.baidu.tieba.c.t tVar4 = this.c;
                j3 = this.b.an;
                tVar4.a("message_id", String.valueOf(j3));
                j4 = this.b.an;
                com.baidu.tieba.c.ag.a("messagePullService", "message_id=", String.valueOf(j4));
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
                    PbActivity.ap = 0L;
                    PbActivity.aq = 0L;
                    PbActivity.ar = 0;
                } else {
                    PbActivity.ar = 1;
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
        ListView listView;
        boolean z;
        boolean z2;
        LinearLayout linearLayout2;
        TranslateAnimation translateAnimation;
        ListView listView2;
        ca caVar;
        boolean z3;
        boolean z4;
        LinearLayout linearLayout3;
        TranslateAnimation translateAnimation2;
        com.baidu.tieba.b.q qVar;
        com.baidu.tieba.b.q qVar2;
        com.baidu.tieba.b.q qVar3;
        com.baidu.tieba.b.q qVar4;
        com.baidu.tieba.b.q qVar5;
        ca caVar2;
        ca caVar3;
        ca caVar4;
        ca caVar5;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        b bVar;
        b bVar2;
        ca caVar6;
        ca caVar7;
        ca caVar8;
        ListView listView3;
        ca caVar9;
        com.baidu.tieba.b.q qVar6;
        com.baidu.tieba.b.q qVar7;
        com.baidu.tieba.b.q qVar8;
        com.baidu.tieba.b.q qVar9;
        com.baidu.tieba.b.q qVar10;
        com.baidu.tieba.b.q qVar11;
        ca caVar10;
        ca caVar11;
        ca caVar12;
        ca caVar13;
        AlertDialog alertDialog3;
        AlertDialog alertDialog4;
        b bVar3;
        b bVar4;
        ca caVar14;
        ca caVar15;
        ca caVar16;
        ca caVar17;
        com.baidu.tieba.b.q qVar12;
        com.baidu.tieba.b.q qVar13;
        com.baidu.tieba.b.q qVar14;
        com.baidu.tieba.b.q qVar15;
        com.baidu.tieba.b.q qVar16;
        com.baidu.tieba.b.q qVar17;
        com.baidu.tieba.b.q qVar18;
        com.baidu.tieba.b.q qVar19;
        com.baidu.tieba.b.q qVar20;
        ca caVar18;
        ca caVar19;
        ca caVar20;
        ca caVar21;
        com.baidu.tieba.b.q qVar21;
        com.baidu.tieba.b.q qVar22;
        com.baidu.tieba.b.q qVar23;
        com.baidu.tieba.b.q qVar24;
        com.baidu.tieba.b.q qVar25;
        com.baidu.tieba.b.q qVar26;
        com.baidu.tieba.b.q qVar27;
        com.baidu.tieba.b.q qVar28;
        com.baidu.tieba.b.q qVar29;
        com.baidu.tieba.b.q qVar30;
        com.baidu.tieba.b.q qVar31;
        ListView listView4;
        com.baidu.tieba.b.q qVar32;
        com.baidu.tieba.b.q qVar33;
        com.baidu.tieba.b.q qVar34;
        com.baidu.tieba.b.q qVar35;
        com.baidu.tieba.b.q qVar36;
        com.baidu.tieba.b.q qVar37;
        com.baidu.tieba.b.q qVar38;
        com.baidu.tieba.b.q qVar39;
        com.baidu.tieba.b.q qVar40;
        com.baidu.tieba.b.q qVar41;
        com.baidu.tieba.b.q qVar42;
        com.baidu.tieba.b.q qVar43;
        com.baidu.tieba.b.q qVar44;
        ca caVar22;
        ca caVar23;
        ListView listView5;
        ca caVar24;
        ca caVar25;
        com.baidu.tieba.b.q qVar45;
        com.baidu.tieba.b.q qVar46;
        com.baidu.tieba.b.q qVar47;
        com.baidu.tieba.b.q qVar48;
        com.baidu.tieba.b.q qVar49;
        com.baidu.tieba.b.q qVar50;
        com.baidu.tieba.b.q qVar51;
        com.baidu.tieba.b.q qVar52;
        com.baidu.tieba.b.q qVar53;
        com.baidu.tieba.b.q qVar54;
        com.baidu.tieba.b.q qVar55;
        com.baidu.tieba.b.q qVar56;
        com.baidu.tieba.b.q qVar57;
        com.baidu.tieba.b.q qVar58;
        ca caVar26;
        ca caVar27;
        ca caVar28;
        ca caVar29;
        AlertDialog alertDialog5;
        AlertDialog alertDialog6;
        b bVar5;
        b bVar6;
        ca caVar30;
        ca caVar31;
        ca caVar32;
        ca caVar33;
        com.baidu.tieba.b.q qVar59;
        com.baidu.tieba.b.q qVar60;
        com.baidu.tieba.b.q qVar61;
        com.baidu.tieba.b.q qVar62;
        AlertDialog alertDialog7;
        AlertDialog alertDialog8;
        AlertDialog alertDialog9;
        try {
            if (aiVar != null) {
                qVar = this.b.p;
                com.baidu.tieba.a.ai a = qVar.a();
                this.b.ag = null;
                qVar2 = this.b.p;
                qVar2.c(aiVar.e().c());
                qVar3 = this.b.p;
                qVar3.d(aiVar.e().d());
                if (this.d == 3) {
                    qVar52 = this.b.p;
                    qVar52.a(aiVar);
                    qVar53 = this.b.p;
                    if (qVar53.c()) {
                        qVar59 = this.b.p;
                        qVar60 = this.b.p;
                        qVar59.a(qVar60.a().e().b());
                        qVar61 = this.b.p;
                        qVar62 = this.b.p;
                        qVar61.b(qVar62.a().e().b());
                    } else {
                        qVar54 = this.b.p;
                        qVar55 = this.b.p;
                        qVar54.a(qVar55.a().e().a());
                        qVar56 = this.b.p;
                        qVar57 = this.b.p;
                        qVar56.b(qVar57.a().e().a());
                    }
                    qVar58 = this.b.p;
                    if (qVar58.c()) {
                        if (aiVar.e().c() == 1) {
                            caVar33 = this.b.n;
                            caVar33.b(2);
                        } else {
                            caVar30 = this.b.n;
                            caVar30.b(1);
                        }
                        if (aiVar.e().d() == 1) {
                            caVar32 = this.b.n;
                            caVar32.a(2);
                        } else {
                            caVar31 = this.b.n;
                            caVar31.a(0);
                        }
                    } else {
                        if (aiVar.e().c() == 1) {
                            caVar29 = this.b.n;
                            caVar29.b(2);
                        } else {
                            caVar26 = this.b.n;
                            caVar26.b(0);
                        }
                        if (aiVar.e().d() == 1) {
                            caVar28 = this.b.n;
                            caVar28.a(2);
                        } else {
                            caVar27 = this.b.n;
                            caVar27.a(1);
                        }
                    }
                    this.b.a(true);
                    alertDialog5 = this.b.y;
                    if (alertDialog5 != null) {
                        alertDialog6 = this.b.y;
                        if (alertDialog6.isShowing()) {
                            bVar5 = this.b.ae;
                            if (bVar5 != null) {
                                bVar6 = this.b.ae;
                                bVar6.notifyDataSetInvalidated();
                            }
                        }
                    }
                } else if (a != null && this.d == 2) {
                    if (a != null) {
                        listView4 = this.b.d;
                        int firstVisiblePosition = listView4.getFirstVisiblePosition();
                        ArrayList d = a.d();
                        ArrayList d2 = aiVar.d();
                        int size = firstVisiblePosition + d2.size();
                        d.addAll(0, d2);
                        a.a(aiVar.e());
                        a.a(aiVar.a());
                        a.a(aiVar.b());
                        a.a(aiVar.f());
                        qVar32 = this.b.p;
                        if (qVar32.c()) {
                            qVar45 = this.b.p;
                            qVar45.b(aiVar.e().b());
                            qVar46 = this.b.p;
                            int k = qVar46.k();
                            qVar47 = this.b.p;
                            int l = k - qVar47.l();
                            qVar48 = this.b.p;
                            if (l >= qVar48.o()) {
                                qVar49 = this.b.p;
                                qVar50 = this.b.p;
                                int l2 = qVar50.l();
                                qVar51 = this.b.p;
                                qVar49.a((l2 + qVar51.o()) - 1);
                            }
                        } else {
                            qVar33 = this.b.p;
                            if (!qVar33.m()) {
                                qVar34 = this.b.p;
                                qVar34.a(aiVar.e().b());
                            } else if (a.e().d() == 1) {
                                qVar42 = this.b.p;
                                qVar43 = this.b.p;
                                qVar42.a(qVar43.k() + 1);
                            } else {
                                qVar41 = this.b.p;
                                qVar41.a(aiVar.e().a());
                            }
                            qVar35 = this.b.p;
                            int k2 = qVar35.k();
                            qVar36 = this.b.p;
                            int l3 = k2 - qVar36.l();
                            qVar37 = this.b.p;
                            if (l3 >= qVar37.o()) {
                                qVar38 = this.b.p;
                                qVar39 = this.b.p;
                                int k3 = qVar39.k();
                                qVar40 = this.b.p;
                                qVar38.b((k3 - qVar40.o()) + 1);
                            }
                        }
                        qVar44 = this.b.p;
                        if (qVar44.c()) {
                            if (a.e().d() == 1) {
                                caVar25 = this.b.n;
                                caVar25.a(2);
                            } else {
                                caVar24 = this.b.n;
                                caVar24.a(0);
                            }
                        } else if (a.e().d() == 1) {
                            caVar23 = this.b.n;
                            caVar23.a(2);
                        } else {
                            caVar22 = this.b.n;
                            caVar22.a(1);
                        }
                        listView5 = this.b.d;
                        listView5.setSelection(size);
                    }
                } else if (a != null && this.d == 1) {
                    a.d().addAll(aiVar.d());
                    a.a(aiVar.e());
                    a.a(aiVar.a());
                    a.a(aiVar.b());
                    a.a(aiVar.f());
                    qVar12 = this.b.p;
                    if (qVar12.c()) {
                        qVar21 = this.b.p;
                        if (!qVar21.m()) {
                            qVar22 = this.b.p;
                            qVar22.a(aiVar.e().b());
                        } else if (a.e().c() == 1) {
                            qVar30 = this.b.p;
                            qVar31 = this.b.p;
                            qVar30.a(qVar31.k() + 1);
                        } else {
                            qVar29 = this.b.p;
                            qVar29.a(aiVar.e().a());
                        }
                        qVar23 = this.b.p;
                        int k4 = qVar23.k();
                        qVar24 = this.b.p;
                        int l4 = k4 - qVar24.l();
                        qVar25 = this.b.p;
                        if (l4 >= qVar25.o()) {
                            qVar26 = this.b.p;
                            qVar27 = this.b.p;
                            int k5 = qVar27.k();
                            qVar28 = this.b.p;
                            qVar26.b((k5 - qVar28.o()) + 1);
                        }
                    } else {
                        qVar13 = this.b.p;
                        qVar13.b(aiVar.e().b());
                        qVar14 = this.b.p;
                        int k6 = qVar14.k();
                        qVar15 = this.b.p;
                        int l5 = k6 - qVar15.l();
                        qVar16 = this.b.p;
                        if (l5 >= qVar16.o()) {
                            qVar17 = this.b.p;
                            qVar18 = this.b.p;
                            int l6 = qVar18.l();
                            qVar19 = this.b.p;
                            qVar17.a((l6 + qVar19.o()) - 1);
                        }
                    }
                    qVar20 = this.b.p;
                    if (qVar20.c()) {
                        if (a.e().c() == 1) {
                            caVar21 = this.b.n;
                            caVar21.b(2);
                        } else {
                            caVar20 = this.b.n;
                            caVar20.b(1);
                        }
                    } else if (a.e().c() == 1) {
                        caVar19 = this.b.n;
                        caVar19.b(2);
                    } else {
                        caVar18 = this.b.n;
                        caVar18.b(0);
                    }
                } else if (this.d == 4 || this.d == 6) {
                    qVar4 = this.b.p;
                    qVar4.a(aiVar);
                    qVar5 = this.b.p;
                    if (!qVar5.c()) {
                        this.b.al = true;
                        if (aiVar.e().c() == 1) {
                            caVar5 = this.b.n;
                            caVar5.b(2);
                        } else {
                            caVar2 = this.b.n;
                            caVar2.b(0);
                        }
                        if (aiVar.e().d() == 1) {
                            caVar4 = this.b.n;
                            caVar4.a(2);
                        } else {
                            caVar3 = this.b.n;
                            caVar3.a(1);
                        }
                    } else {
                        if (aiVar.e().c() == 1) {
                            caVar9 = this.b.n;
                            caVar9.b(2);
                        } else {
                            caVar6 = this.b.n;
                            caVar6.b(1);
                        }
                        if (aiVar.e().d() == 1) {
                            caVar8 = this.b.n;
                            caVar8.a(2);
                            listView3 = this.b.d;
                            listView3.setSelection(1);
                        } else {
                            caVar7 = this.b.n;
                            caVar7.a(0);
                        }
                    }
                    alertDialog = this.b.y;
                    if (alertDialog != null) {
                        alertDialog2 = this.b.y;
                        if (alertDialog2.isShowing()) {
                            bVar = this.b.ae;
                            if (bVar != null) {
                                bVar2 = this.b.ae;
                                bVar2.notifyDataSetInvalidated();
                            }
                        }
                    }
                } else if (this.d == 5) {
                    qVar6 = this.b.p;
                    qVar6.a(aiVar);
                    qVar7 = this.b.p;
                    qVar8 = this.b.p;
                    qVar7.a(qVar8.a().e().b());
                    qVar9 = this.b.p;
                    qVar10 = this.b.p;
                    qVar9.b(qVar10.a().e().b());
                    qVar11 = this.b.p;
                    if (qVar11.c()) {
                        if (aiVar.e().c() == 1) {
                            caVar17 = this.b.n;
                            caVar17.b(2);
                        } else {
                            caVar14 = this.b.n;
                            caVar14.b(1);
                        }
                        if (aiVar.e().d() == 1) {
                            caVar16 = this.b.n;
                            caVar16.a(2);
                        } else {
                            caVar15 = this.b.n;
                            caVar15.a(0);
                        }
                    } else {
                        if (aiVar.e().c() == 1) {
                            caVar13 = this.b.n;
                            caVar13.b(2);
                        } else {
                            caVar10 = this.b.n;
                            caVar10.b(0);
                        }
                        if (aiVar.e().d() == 1) {
                            caVar12 = this.b.n;
                            caVar12.a(2);
                        } else {
                            caVar11 = this.b.n;
                            caVar11.a(1);
                        }
                    }
                    alertDialog3 = this.b.y;
                    if (alertDialog3 != null) {
                        alertDialog4 = this.b.y;
                        if (alertDialog4.isShowing()) {
                            bVar3 = this.b.ae;
                            if (bVar3 != null) {
                                bVar4 = this.b.ae;
                                bVar4.notifyDataSetInvalidated();
                            }
                        }
                    }
                }
                PbActivity.ap = (System.nanoTime() - this.f) / 1000000;
                if (this.c != null) {
                    PbActivity.aq = this.c.a();
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
                        builder.setPositiveButton(this.b.getString(R.string.retry), new bx(this));
                        builder.setNegativeButton(this.b.getString(R.string.cancel), new by(this));
                        alertDialog7 = this.b.y;
                        if (alertDialog7 != null) {
                            alertDialog8 = this.b.y;
                            if (alertDialog8.isShowing()) {
                                alertDialog9 = this.b.y;
                                alertDialog9.dismiss();
                            }
                        }
                        builder.create().show();
                    }
                } else {
                    this.b.b(this.c.f());
                }
            }
            this.b.D();
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        this.b.o = null;
        b();
        if (this.d == 5) {
            listView2 = this.b.d;
            listView2.setSelection(0);
            caVar = this.b.n;
            caVar.notifyDataSetInvalidated();
            z3 = this.b.aw;
            if (!z3) {
                z4 = this.b.av;
                if (!z4) {
                    linearLayout3 = this.b.C;
                    translateAnimation2 = this.b.at;
                    linearLayout3.startAnimation(translateAnimation2);
                }
            }
        }
        if (this.d == 3 || this.d == 4 || this.d == 6) {
            linearLayout = this.b.C;
            linearLayout.invalidate();
        }
        listView = this.b.d;
        if (listView.getFirstVisiblePosition() == 0) {
            z = this.b.aw;
            if (!z) {
                z2 = this.b.av;
                if (!z2) {
                    linearLayout2 = this.b.C;
                    translateAnimation = this.b.at;
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
        ca caVar;
        ca caVar2;
        ca caVar3;
        ca caVar4;
        ca caVar5;
        ca caVar6;
        ca caVar7;
        ca caVar8;
        ProgressBar progressBar2;
        progressBar = this.b.s;
        if (progressBar.getVisibility() == 0) {
            progressBar2 = this.b.s;
            progressBar2.setVisibility(8);
        }
        caVar = this.b.n;
        if (caVar.g()) {
            caVar6 = this.b.n;
            caVar6.a(false);
            caVar7 = this.b.n;
            if (caVar7.e()) {
                caVar8 = this.b.n;
                caVar8.notifyDataSetChanged();
            }
        }
        caVar2 = this.b.n;
        if (caVar2.h()) {
            caVar3 = this.b.n;
            caVar3.b(false);
            caVar4 = this.b.n;
            if (caVar4.c()) {
                caVar5 = this.b.n;
                caVar5.notifyDataSetInvalidated();
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f = System.nanoTime();
    }
}
