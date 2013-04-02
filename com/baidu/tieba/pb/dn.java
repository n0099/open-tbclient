package com.baidu.tieba.pb;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn extends AsyncTask {
    final /* synthetic */ SubPbActivity a;
    private com.baidu.tieba.c.t b = null;
    private int c;
    private int d;

    public dn(SubPbActivity subPbActivity, int i) {
        int i2;
        com.baidu.tieba.b.w wVar;
        int i3;
        com.baidu.tieba.b.w wVar2;
        com.baidu.tieba.b.w wVar3;
        int i4;
        int i5;
        this.a = subPbActivity;
        this.c = 0;
        this.d = 3;
        this.d = i;
        switch (i) {
            case 1:
                wVar = subPbActivity.g;
                if (wVar != null) {
                    wVar2 = subPbActivity.g;
                    if (wVar2.a() != null) {
                        wVar3 = subPbActivity.g;
                        int c = wVar3.a().c();
                        i4 = subPbActivity.F;
                        if (c > i4) {
                            i5 = subPbActivity.F;
                            this.c = i5 + 1;
                            return;
                        }
                    }
                }
                i3 = subPbActivity.F;
                this.c = i3 > 0 ? subPbActivity.F : 1;
                return;
            case 2:
                i2 = subPbActivity.E;
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
        com.baidu.tieba.b.w wVar;
        com.baidu.tieba.b.w wVar2;
        Cdo cdo;
        int i;
        Cdo cdo2;
        com.baidu.tieba.b.w wVar3;
        Cdo cdo3;
        List list2;
        Cdo cdo4;
        List list3;
        List list4;
        boolean z;
        List list5;
        List list6;
        List list7;
        Cdo cdo5;
        Cdo cdo6;
        List list8;
        Cdo cdo7;
        Cdo cdo8;
        try {
            this.a.m();
            list = this.a.G;
            if (list != null) {
                list8 = this.a.G;
                if (list8.size() >= 200) {
                    cdo7 = this.a.h;
                    cdo7.c(0);
                    cdo8 = this.a.h;
                    cdo8.notifyDataSetChanged();
                    return;
                }
            }
            wVar = this.a.g;
            com.baidu.tieba.a.at a = wVar.a();
            wVar2 = this.a.g;
            if (wVar2 != null && a != null) {
                if (this.d == 1) {
                    this.a.F = a.e();
                }
                if (this.d == 2) {
                    this.a.E = a.e();
                }
                if (a.e() < a.c()) {
                    cdo6 = this.a.h;
                    cdo6.c(2);
                } else {
                    cdo = this.a.h;
                    cdo.c(0);
                }
                i = this.a.E;
                if (i > 1) {
                    cdo5 = this.a.h;
                    cdo5.b(2);
                } else {
                    cdo2 = this.a.h;
                    cdo2.b(0);
                }
                wVar3 = this.a.g;
                List b = wVar3.a().b();
                if (b != null && b.size() > 0) {
                    int size = b.size();
                    if (this.d == 3) {
                        list7 = this.a.G;
                        list7.addAll(b);
                    }
                    if (this.d == 1) {
                        list4 = this.a.G;
                        int size2 = list4.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            String a2 = ((com.baidu.tieba.a.an) b.get(i2)).a();
                            if (a2 != null) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= size2) {
                                        z = false;
                                        break;
                                    }
                                    list6 = this.a.G;
                                    if (a2.equals(((com.baidu.tieba.a.an) list6.get(i3)).a())) {
                                        z = true;
                                        break;
                                    }
                                    i3++;
                                }
                                if (!z) {
                                    list5 = this.a.G;
                                    list5.add((com.baidu.tieba.a.an) b.get(i2));
                                }
                            }
                        }
                    }
                    if (this.d == 2) {
                        list3 = this.a.G;
                        list3.addAll(0, b);
                    }
                    cdo3 = this.a.h;
                    list2 = this.a.G;
                    cdo3.a(list2);
                    cdo4 = this.a.h;
                    cdo4.notifyDataSetChanged();
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.e(getClass().getName(), "refreshActivity", e.getMessage());
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
        str = this.a.z;
        tVar.a("kz", str);
        z = this.a.n;
        if (!z) {
            com.baidu.tieba.c.t tVar2 = this.b;
            str5 = this.a.i;
            tVar2.a("pid", str5);
            this.b.a("pn", String.valueOf(this.c));
        } else {
            com.baidu.tieba.c.t tVar3 = this.b;
            str2 = this.a.i;
            tVar3.a("spid", str2);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.tieba.b.w wVar;
        com.baidu.tieba.b.w wVar2;
        Cdo cdo;
        com.baidu.tieba.b.w wVar3;
        super.onPostExecute(str);
        try {
            if (this.b != null) {
                if (this.b.b()) {
                    this.a.g = new com.baidu.tieba.b.w(this.a, str);
                    SubPbActivity subPbActivity = this.a;
                    wVar = this.a.g;
                    subPbActivity.j = wVar.a().f().b();
                    SubPbActivity subPbActivity2 = this.a;
                    wVar2 = this.a.g;
                    subPbActivity2.k = wVar2.a().f().c();
                    cdo = this.a.h;
                    wVar3 = this.a.g;
                    cdo.a(wVar3);
                    this.a.n = false;
                    b();
                } else {
                    this.a.b(this.b.f());
                    int d = this.b.d();
                    if (d == 4 || d == 28 || d == 29) {
                        this.a.a();
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        this.a.D = null;
        c();
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
        c();
        super.cancel(true);
    }

    private void c() {
        ProgressBar progressBar;
        Cdo cdo;
        Cdo cdo2;
        Cdo cdo3;
        Cdo cdo4;
        Cdo cdo5;
        Cdo cdo6;
        Cdo cdo7;
        Cdo cdo8;
        ProgressBar progressBar2;
        progressBar = this.a.o;
        if (progressBar.getVisibility() == 0) {
            progressBar2 = this.a.o;
            progressBar2.setVisibility(8);
        }
        cdo = this.a.h;
        if (cdo.a()) {
            cdo6 = this.a.h;
            cdo6.b(false);
            cdo7 = this.a.h;
            if (cdo7.d()) {
                cdo8 = this.a.h;
                cdo8.notifyDataSetChanged();
            }
        }
        cdo2 = this.a.h;
        if (cdo2.b()) {
            cdo3 = this.a.h;
            cdo3.c(false);
            cdo4 = this.a.h;
            if (cdo4.c()) {
                cdo5 = this.a.h;
                cdo5.notifyDataSetInvalidated();
            }
        }
    }
}
