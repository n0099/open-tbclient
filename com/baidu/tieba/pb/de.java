package com.baidu.tieba.pb;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class de extends AsyncTask {
    final /* synthetic */ SubPbActivity a;
    private com.baidu.tieba.c.t b = null;
    private int c;
    private int d;

    public de(SubPbActivity subPbActivity, int i) {
        int i2;
        List list;
        int i3;
        int i4;
        this.a = subPbActivity;
        this.c = 0;
        this.d = 3;
        this.d = i;
        switch (i) {
            case 1:
                list = subPbActivity.J;
                if (list.size() % 10 == 0) {
                    i4 = subPbActivity.I;
                    this.c = i4 + 1;
                    return;
                }
                i3 = subPbActivity.I;
                this.c = i3;
                return;
            case 2:
                i2 = subPbActivity.H;
                this.c = i2 - 1;
                return;
            case 3:
                this.c = 1;
                return;
            default:
                return;
        }
    }

    private void b() {
        List list;
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        df dfVar;
        int i;
        df dfVar2;
        com.baidu.tieba.b.r rVar3;
        df dfVar3;
        List list2;
        df dfVar4;
        List list3;
        List list4;
        boolean z;
        List list5;
        List list6;
        List list7;
        df dfVar5;
        df dfVar6;
        List list8;
        df dfVar7;
        df dfVar8;
        try {
            this.a.l();
            list = this.a.J;
            if (list != null) {
                list8 = this.a.J;
                if (list8.size() >= 200) {
                    dfVar7 = this.a.g;
                    dfVar7.c(0);
                    dfVar8 = this.a.g;
                    dfVar8.notifyDataSetChanged();
                    return;
                }
            }
            rVar = this.a.f;
            com.baidu.tieba.a.aq a = rVar.a();
            rVar2 = this.a.f;
            if (rVar2 == null || a == null) {
                return;
            }
            if (this.d == 1) {
                this.a.I = a.e();
            }
            if (this.d == 2) {
                this.a.H = a.e();
            }
            if (a.e() < a.c()) {
                dfVar6 = this.a.g;
                dfVar6.c(2);
            } else {
                dfVar = this.a.g;
                dfVar.c(0);
            }
            i = this.a.H;
            if (i > 1) {
                dfVar5 = this.a.g;
                dfVar5.b(2);
            } else {
                dfVar2 = this.a.g;
                dfVar2.b(0);
            }
            rVar3 = this.a.f;
            List b = rVar3.a().b();
            if (b == null || b.size() <= 0) {
                return;
            }
            int size = b.size();
            if (this.d == 3) {
                list7 = this.a.J;
                list7.addAll(b);
            }
            if (this.d == 1) {
                list4 = this.a.J;
                int size2 = list4.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String a2 = ((com.baidu.tieba.a.am) b.get(i2)).a();
                    if (a2 != null) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size2) {
                                z = false;
                                break;
                            }
                            list6 = this.a.J;
                            if (a2.equals(((com.baidu.tieba.a.am) list6.get(i3)).a())) {
                                z = true;
                                break;
                            }
                            i3++;
                        }
                        if (!z) {
                            list5 = this.a.J;
                            list5.add((com.baidu.tieba.a.am) b.get(i2));
                        }
                    }
                }
            }
            if (this.d == 2) {
                list3 = this.a.J;
                list3.addAll(0, b);
            }
            dfVar3 = this.a.g;
            list2 = this.a.J;
            dfVar3.a(list2);
            dfVar4 = this.a.g;
            dfVar4.notifyDataSetChanged();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.c(getClass().getName(), "refreshActivity", e.getMessage());
        }
    }

    private void c() {
        ProgressBar progressBar;
        df dfVar;
        df dfVar2;
        df dfVar3;
        df dfVar4;
        df dfVar5;
        df dfVar6;
        df dfVar7;
        df dfVar8;
        ProgressBar progressBar2;
        progressBar = this.a.r;
        if (progressBar.getVisibility() == 0) {
            progressBar2 = this.a.r;
            progressBar2.setVisibility(8);
        }
        dfVar = this.a.g;
        if (dfVar.a()) {
            dfVar6 = this.a.g;
            dfVar6.b(false);
            dfVar7 = this.a.g;
            if (dfVar7.d()) {
                dfVar8 = this.a.g;
                dfVar8.notifyDataSetChanged();
            }
        }
        dfVar2 = this.a.g;
        if (dfVar2.b()) {
            dfVar3 = this.a.g;
            dfVar3.c(false);
            dfVar4 = this.a.g;
            if (dfVar4.c()) {
                dfVar5 = this.a.g;
                dfVar5.notifyDataSetInvalidated();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String str;
        boolean z;
        String str2;
        String str3;
        String str4;
        String str5;
        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/f/pb/floor");
        com.baidu.tieba.c.t tVar = this.b;
        str = this.a.h;
        tVar.a("kz", str);
        z = this.a.q;
        if (z) {
            com.baidu.tieba.c.t tVar2 = this.b;
            str2 = this.a.i;
            tVar2.a("spid", str2);
        } else {
            com.baidu.tieba.c.t tVar3 = this.b;
            str5 = this.a.i;
            tVar3.a("pid", str5);
            this.b.a("pn", String.valueOf(this.c));
        }
        str3 = this.a.l;
        if (str3 != null) {
            com.baidu.tieba.c.t tVar4 = this.b;
            str4 = this.a.l;
            tVar4.a("st_type", str4);
        }
        this.b.d(true);
        return this.b.i();
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
        c();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        df dfVar;
        com.baidu.tieba.b.r rVar3;
        super.onPostExecute(str);
        try {
            if (this.b != null) {
                if (this.b.b()) {
                    this.a.f = new com.baidu.tieba.b.r(this.a, str);
                    SubPbActivity subPbActivity = this.a;
                    rVar = this.a.f;
                    subPbActivity.j = rVar.a().f().b();
                    SubPbActivity subPbActivity2 = this.a;
                    rVar2 = this.a.f;
                    subPbActivity2.k = rVar2.a().f().c();
                    dfVar = this.a.g;
                    rVar3 = this.a.f;
                    dfVar.a(rVar3);
                    this.a.q = false;
                    this.a.n();
                    b();
                } else {
                    this.a.b(this.b.f());
                    int d = this.b.d();
                    if (d == 4 || d == 28 || d == 29) {
                        this.a.p();
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        this.a.G = null;
        c();
    }
}
