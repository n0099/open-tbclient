package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends AsyncTask {
    ArrayList a;
    final /* synthetic */ PbActivity b;
    private int d;
    private String e;
    private com.baidu.tieba.c.t c = null;
    private volatile long f = 0;

    public bp(PbActivity pbActivity, String str, ArrayList arrayList, int i) {
        this.b = pbActivity;
        this.d = 3;
        this.e = null;
        this.a = null;
        this.e = str;
        this.a = arrayList;
        this.d = i;
    }

    private void b() {
        ProgressBar progressBar;
        bt btVar;
        bt btVar2;
        bt btVar3;
        bt btVar4;
        bt btVar5;
        bt btVar6;
        bt btVar7;
        bt btVar8;
        ProgressBar progressBar2;
        progressBar = this.b.p;
        if (progressBar.getVisibility() == 0) {
            progressBar2 = this.b.p;
            progressBar2.setVisibility(8);
        }
        btVar = this.b.l;
        if (btVar.g()) {
            btVar6 = this.b.l;
            btVar6.a(false);
            btVar7 = this.b.l;
            if (btVar7.e()) {
                btVar8 = this.b.l;
                btVar8.notifyDataSetChanged();
            }
        }
        btVar2 = this.b.l;
        if (btVar2.h()) {
            btVar3 = this.b.l;
            btVar3.b(false);
            btVar4 = this.b.l;
            if (btVar4.c()) {
                btVar5 = this.b.l;
                btVar5.notifyDataSetInvalidated();
            }
        }
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
            z = this.b.am;
            if (z) {
                this.b.am = false;
                this.c.a("msg_click", "1");
                com.baidu.tieba.c.t tVar4 = this.c;
                j3 = this.b.an;
                tVar4.a("message_id", String.valueOf(j3));
                j4 = this.b.an;
                com.baidu.tieba.c.ae.a("messagePullService", "message_id=", String.valueOf(j4));
            }
            String i3 = this.c.i();
            if (this.c.b()) {
                com.baidu.tieba.a.ak akVar2 = new com.baidu.tieba.a.ak();
                try {
                    akVar2.a(i3);
                    int size = akVar2.c().size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((com.baidu.tieba.a.am) akVar2.c().get(i4)).b(this.b);
                        ((com.baidu.tieba.a.am) akVar2.c().get(i4)).a((ArrayList) null);
                    }
                    this.b.ak = akVar2.a().c();
                    akVar = akVar2;
                } catch (Exception e2) {
                    e = e2;
                    akVar = akVar2;
                    com.baidu.tieba.c.ae.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
                    return akVar;
                }
            } else {
                akVar = null;
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
                com.baidu.tieba.c.ae.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
                return akVar;
            }
        } catch (Exception e4) {
            akVar = null;
            e = e4;
        }
        return akVar;
    }

    public void a() {
        if (this.c != null) {
            this.c.g();
        }
        b();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.ak akVar) {
        bt btVar;
        TextView textView;
        String str;
        com.baidu.tieba.b.n nVar;
        com.baidu.tieba.b.n nVar2;
        com.baidu.tieba.b.n nVar3;
        com.baidu.tieba.b.n nVar4;
        com.baidu.tieba.b.n nVar5;
        com.baidu.tieba.b.n nVar6;
        com.baidu.tieba.b.n nVar7;
        com.baidu.tieba.b.n nVar8;
        com.baidu.tieba.b.n nVar9;
        bt btVar2;
        bt btVar3;
        bt btVar4;
        bt btVar5;
        AlertDialog alertDialog;
        ListView listView;
        AlertDialog alertDialog2;
        b bVar;
        b bVar2;
        bt btVar6;
        bt btVar7;
        bt btVar8;
        bt btVar9;
        com.baidu.tieba.b.n nVar10;
        com.baidu.tieba.b.n nVar11;
        bt btVar10;
        bt btVar11;
        bt btVar12;
        bt btVar13;
        AlertDialog alertDialog3;
        AlertDialog alertDialog4;
        b bVar3;
        b bVar4;
        bt btVar14;
        bt btVar15;
        bt btVar16;
        ListView listView2;
        bt btVar17;
        com.baidu.tieba.b.n nVar12;
        com.baidu.tieba.b.n nVar13;
        com.baidu.tieba.b.n nVar14;
        com.baidu.tieba.b.n nVar15;
        com.baidu.tieba.b.n nVar16;
        com.baidu.tieba.b.n nVar17;
        com.baidu.tieba.b.n nVar18;
        com.baidu.tieba.b.n nVar19;
        com.baidu.tieba.b.n nVar20;
        bt btVar18;
        bt btVar19;
        bt btVar20;
        bt btVar21;
        com.baidu.tieba.b.n nVar21;
        com.baidu.tieba.b.n nVar22;
        com.baidu.tieba.b.n nVar23;
        com.baidu.tieba.b.n nVar24;
        com.baidu.tieba.b.n nVar25;
        com.baidu.tieba.b.n nVar26;
        com.baidu.tieba.b.n nVar27;
        com.baidu.tieba.b.n nVar28;
        com.baidu.tieba.b.n nVar29;
        com.baidu.tieba.b.n nVar30;
        com.baidu.tieba.b.n nVar31;
        ListView listView3;
        com.baidu.tieba.b.n nVar32;
        com.baidu.tieba.b.n nVar33;
        com.baidu.tieba.b.n nVar34;
        com.baidu.tieba.b.n nVar35;
        com.baidu.tieba.b.n nVar36;
        com.baidu.tieba.b.n nVar37;
        com.baidu.tieba.b.n nVar38;
        com.baidu.tieba.b.n nVar39;
        com.baidu.tieba.b.n nVar40;
        com.baidu.tieba.b.n nVar41;
        com.baidu.tieba.b.n nVar42;
        com.baidu.tieba.b.n nVar43;
        com.baidu.tieba.b.n nVar44;
        bt btVar22;
        bt btVar23;
        ListView listView4;
        bt btVar24;
        bt btVar25;
        com.baidu.tieba.b.n nVar45;
        com.baidu.tieba.b.n nVar46;
        com.baidu.tieba.b.n nVar47;
        com.baidu.tieba.b.n nVar48;
        com.baidu.tieba.b.n nVar49;
        com.baidu.tieba.b.n nVar50;
        com.baidu.tieba.b.n nVar51;
        com.baidu.tieba.b.n nVar52;
        com.baidu.tieba.b.n nVar53;
        com.baidu.tieba.b.n nVar54;
        com.baidu.tieba.b.n nVar55;
        com.baidu.tieba.b.n nVar56;
        com.baidu.tieba.b.n nVar57;
        com.baidu.tieba.b.n nVar58;
        bt btVar26;
        bt btVar27;
        bt btVar28;
        bt btVar29;
        AlertDialog alertDialog5;
        AlertDialog alertDialog6;
        b bVar5;
        b bVar6;
        bt btVar30;
        bt btVar31;
        bt btVar32;
        bt btVar33;
        com.baidu.tieba.b.n nVar59;
        com.baidu.tieba.b.n nVar60;
        com.baidu.tieba.b.n nVar61;
        com.baidu.tieba.b.n nVar62;
        AlertDialog alertDialog7;
        AlertDialog alertDialog8;
        AlertDialog alertDialog9;
        try {
            if (akVar != null) {
                textView = this.b.aj;
                str = this.b.ak;
                textView.setText(str);
                nVar = this.b.n;
                com.baidu.tieba.a.ak a = nVar.a();
                this.b.ad = null;
                nVar2 = this.b.n;
                nVar2.c(akVar.d().c());
                nVar3 = this.b.n;
                nVar3.d(akVar.d().d());
                if (this.d == 3) {
                    nVar52 = this.b.n;
                    nVar52.a(akVar);
                    nVar53 = this.b.n;
                    if (nVar53.c()) {
                        nVar59 = this.b.n;
                        nVar60 = this.b.n;
                        nVar59.a(nVar60.a().d().b());
                        nVar61 = this.b.n;
                        nVar62 = this.b.n;
                        nVar61.b(nVar62.a().d().b());
                    } else {
                        nVar54 = this.b.n;
                        nVar55 = this.b.n;
                        nVar54.a(nVar55.a().d().a());
                        nVar56 = this.b.n;
                        nVar57 = this.b.n;
                        nVar56.b(nVar57.a().d().a());
                    }
                    nVar58 = this.b.n;
                    if (nVar58.c()) {
                        if (akVar.d().c() == 1) {
                            btVar33 = this.b.l;
                            btVar33.b(2);
                        } else {
                            btVar30 = this.b.l;
                            btVar30.b(1);
                        }
                        if (akVar.d().d() == 1) {
                            btVar32 = this.b.l;
                            btVar32.a(2);
                        } else {
                            btVar31 = this.b.l;
                            btVar31.a(0);
                        }
                    } else {
                        if (akVar.d().c() == 1) {
                            btVar29 = this.b.l;
                            btVar29.b(2);
                        } else {
                            btVar26 = this.b.l;
                            btVar26.b(0);
                        }
                        if (akVar.d().d() == 1) {
                            btVar28 = this.b.l;
                            btVar28.a(2);
                        } else {
                            btVar27 = this.b.l;
                            btVar27.a(1);
                        }
                    }
                    this.b.a(true);
                    alertDialog5 = this.b.v;
                    if (alertDialog5 != null) {
                        alertDialog6 = this.b.v;
                        if (alertDialog6.isShowing()) {
                            bVar5 = this.b.ab;
                            if (bVar5 != null) {
                                bVar6 = this.b.ab;
                                bVar6.notifyDataSetInvalidated();
                            }
                        }
                    }
                } else if (a == null || this.d != 2) {
                    if (a != null && this.d == 1) {
                        a.c().addAll(akVar.c());
                        a.a(akVar.d());
                        a.a(akVar.a());
                        a.a(akVar.b());
                        a.a(akVar.e());
                        nVar12 = this.b.n;
                        if (nVar12.c()) {
                            nVar21 = this.b.n;
                            if (!nVar21.m()) {
                                nVar22 = this.b.n;
                                nVar22.a(akVar.d().b());
                            } else if (a.d().c() == 1) {
                                nVar30 = this.b.n;
                                nVar31 = this.b.n;
                                nVar30.a(nVar31.k() + 1);
                            } else {
                                nVar29 = this.b.n;
                                nVar29.a(akVar.d().a());
                            }
                            nVar23 = this.b.n;
                            int k = nVar23.k();
                            nVar24 = this.b.n;
                            int l = k - nVar24.l();
                            nVar25 = this.b.n;
                            if (l >= nVar25.o()) {
                                nVar26 = this.b.n;
                                nVar27 = this.b.n;
                                int k2 = nVar27.k();
                                nVar28 = this.b.n;
                                nVar26.b((k2 - nVar28.o()) + 1);
                            }
                        } else {
                            nVar13 = this.b.n;
                            nVar13.b(akVar.d().b());
                            nVar14 = this.b.n;
                            int k3 = nVar14.k();
                            nVar15 = this.b.n;
                            int l2 = k3 - nVar15.l();
                            nVar16 = this.b.n;
                            if (l2 >= nVar16.o()) {
                                nVar17 = this.b.n;
                                nVar18 = this.b.n;
                                int l3 = nVar18.l();
                                nVar19 = this.b.n;
                                nVar17.a((l3 + nVar19.o()) - 1);
                            }
                        }
                        nVar20 = this.b.n;
                        if (nVar20.c()) {
                            if (a.d().c() == 1) {
                                btVar21 = this.b.l;
                                btVar21.b(2);
                            } else {
                                btVar20 = this.b.l;
                                btVar20.b(1);
                            }
                        } else if (a.d().c() == 1) {
                            btVar19 = this.b.l;
                            btVar19.b(2);
                        } else {
                            btVar18 = this.b.l;
                            btVar18.b(0);
                        }
                    } else if (this.d == 4) {
                        nVar10 = this.b.n;
                        nVar10.a(akVar);
                        nVar11 = this.b.n;
                        if (nVar11.c()) {
                            if (akVar.d().c() == 1) {
                                btVar17 = this.b.l;
                                btVar17.b(2);
                            } else {
                                btVar14 = this.b.l;
                                btVar14.b(1);
                            }
                            if (akVar.d().d() == 1) {
                                btVar16 = this.b.l;
                                btVar16.a(2);
                                listView2 = this.b.c;
                                listView2.setSelection(1);
                            } else {
                                btVar15 = this.b.l;
                                btVar15.a(0);
                            }
                        } else {
                            this.b.al = true;
                            if (akVar.d().c() == 1) {
                                btVar13 = this.b.l;
                                btVar13.b(2);
                            } else {
                                btVar10 = this.b.l;
                                btVar10.b(0);
                            }
                            if (akVar.d().d() == 1) {
                                btVar12 = this.b.l;
                                btVar12.a(2);
                            } else {
                                btVar11 = this.b.l;
                                btVar11.a(1);
                            }
                        }
                        alertDialog3 = this.b.v;
                        if (alertDialog3 != null) {
                            alertDialog4 = this.b.v;
                            if (alertDialog4.isShowing()) {
                                bVar3 = this.b.ab;
                                if (bVar3 != null) {
                                    bVar4 = this.b.ab;
                                    bVar4.notifyDataSetInvalidated();
                                }
                            }
                        }
                    } else if (this.d == 5) {
                        nVar4 = this.b.n;
                        nVar4.a(akVar);
                        nVar5 = this.b.n;
                        nVar6 = this.b.n;
                        nVar5.a(nVar6.a().d().b());
                        nVar7 = this.b.n;
                        nVar8 = this.b.n;
                        nVar7.b(nVar8.a().d().b());
                        nVar9 = this.b.n;
                        if (nVar9.c()) {
                            if (akVar.d().c() == 1) {
                                btVar9 = this.b.l;
                                btVar9.b(2);
                            } else {
                                btVar6 = this.b.l;
                                btVar6.b(1);
                            }
                            if (akVar.d().d() == 1) {
                                btVar8 = this.b.l;
                                btVar8.a(2);
                            } else {
                                btVar7 = this.b.l;
                                btVar7.a(0);
                            }
                        } else {
                            if (akVar.d().c() == 1) {
                                btVar5 = this.b.l;
                                btVar5.b(2);
                            } else {
                                btVar2 = this.b.l;
                                btVar2.b(0);
                            }
                            if (akVar.d().d() == 1) {
                                btVar4 = this.b.l;
                                btVar4.a(2);
                            } else {
                                btVar3 = this.b.l;
                                btVar3.a(1);
                            }
                        }
                        alertDialog = this.b.v;
                        if (alertDialog != null) {
                            alertDialog2 = this.b.v;
                            if (alertDialog2.isShowing()) {
                                bVar = this.b.ab;
                                if (bVar != null) {
                                    bVar2 = this.b.ab;
                                    bVar2.notifyDataSetInvalidated();
                                }
                            }
                        }
                        if (akVar.c().size() > 0) {
                            listView = this.b.c;
                            listView.setSelection(0);
                        }
                    }
                } else if (a != null) {
                    listView3 = this.b.c;
                    int firstVisiblePosition = listView3.getFirstVisiblePosition();
                    ArrayList c = a.c();
                    ArrayList c2 = akVar.c();
                    int size = firstVisiblePosition + c2.size();
                    c.addAll(0, c2);
                    a.a(akVar.d());
                    a.a(akVar.a());
                    a.a(akVar.b());
                    a.a(akVar.e());
                    nVar32 = this.b.n;
                    if (nVar32.c()) {
                        nVar45 = this.b.n;
                        nVar45.b(akVar.d().b());
                        nVar46 = this.b.n;
                        int k4 = nVar46.k();
                        nVar47 = this.b.n;
                        int l4 = k4 - nVar47.l();
                        nVar48 = this.b.n;
                        if (l4 >= nVar48.o()) {
                            nVar49 = this.b.n;
                            nVar50 = this.b.n;
                            int l5 = nVar50.l();
                            nVar51 = this.b.n;
                            nVar49.a((l5 + nVar51.o()) - 1);
                        }
                    } else {
                        nVar33 = this.b.n;
                        if (!nVar33.m()) {
                            nVar34 = this.b.n;
                            nVar34.a(akVar.d().b());
                        } else if (a.d().d() == 1) {
                            nVar42 = this.b.n;
                            nVar43 = this.b.n;
                            nVar42.a(nVar43.k() + 1);
                        } else {
                            nVar41 = this.b.n;
                            nVar41.a(akVar.d().a());
                        }
                        nVar35 = this.b.n;
                        int k5 = nVar35.k();
                        nVar36 = this.b.n;
                        int l6 = k5 - nVar36.l();
                        nVar37 = this.b.n;
                        if (l6 >= nVar37.o()) {
                            nVar38 = this.b.n;
                            nVar39 = this.b.n;
                            int k6 = nVar39.k();
                            nVar40 = this.b.n;
                            nVar38.b((k6 - nVar40.o()) + 1);
                        }
                    }
                    nVar44 = this.b.n;
                    if (nVar44.c()) {
                        if (a.d().d() == 1) {
                            btVar25 = this.b.l;
                            btVar25.a(2);
                        } else {
                            btVar24 = this.b.l;
                            btVar24.a(0);
                        }
                    } else if (a.d().d() == 1) {
                        btVar23 = this.b.l;
                        btVar23.a(2);
                    } else {
                        btVar22 = this.b.l;
                        btVar22.a(1);
                    }
                    listView4 = this.b.c;
                    listView4.setSelection(size);
                }
                PbActivity.ao = (System.nanoTime() - this.f) / 1000000;
                if (this.c != null) {
                    PbActivity.ap = this.c.a();
                }
            } else if (this.c != null) {
                if (this.d != 3 && this.d != 4) {
                    this.b.b(this.c.f());
                } else if (this.c.c()) {
                    this.b.b(this.c.f());
                    if (this.c.d() == 4 || this.c.d() == 28) {
                        this.b.g();
                        return;
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
                    builder.setTitle(this.b.getString(R.string.error));
                    builder.setMessage(this.c.f());
                    builder.setPositiveButton(this.b.getString(R.string.retry), new bq(this));
                    builder.setNegativeButton(this.b.getString(R.string.cancel), new br(this));
                    alertDialog7 = this.b.v;
                    if (alertDialog7 != null) {
                        alertDialog8 = this.b.v;
                        if (alertDialog8.isShowing()) {
                            alertDialog9 = this.b.v;
                            alertDialog9.dismiss();
                        }
                    }
                    builder.create().show();
                }
            }
            this.b.x();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        this.b.m = null;
        b();
        if (this.d == 5) {
            btVar = this.b.l;
            btVar.notifyDataSetInvalidated();
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f = System.nanoTime();
    }
}
