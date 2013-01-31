package com.baidu.tieba.pb;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg extends AsyncTask {
    final /* synthetic */ SubPbActivity a;
    private com.baidu.tieba.c.t b = null;
    private int c;
    private int d;

    public dg(SubPbActivity subPbActivity, int i) {
        int i2;
        com.baidu.tieba.b.t tVar;
        int i3;
        com.baidu.tieba.b.t tVar2;
        com.baidu.tieba.b.t tVar3;
        int i4;
        int i5;
        this.a = subPbActivity;
        this.c = 0;
        this.d = 3;
        this.d = i;
        switch (i) {
            case 1:
                tVar = subPbActivity.g;
                if (tVar != null) {
                    tVar2 = subPbActivity.g;
                    if (tVar2.a() != null) {
                        tVar3 = subPbActivity.g;
                        int c = tVar3.a().c();
                        i4 = subPbActivity.J;
                        if (c > i4) {
                            i5 = subPbActivity.J;
                            this.c = i5 + 1;
                            return;
                        }
                    }
                }
                i3 = subPbActivity.J;
                this.c = i3 > 0 ? subPbActivity.J : 1;
                return;
            case 2:
                i2 = subPbActivity.I;
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
        com.baidu.tieba.b.t tVar;
        com.baidu.tieba.b.t tVar2;
        dh dhVar;
        int i;
        dh dhVar2;
        com.baidu.tieba.b.t tVar3;
        dh dhVar3;
        List list2;
        dh dhVar4;
        List list3;
        List list4;
        boolean z;
        List list5;
        List list6;
        List list7;
        dh dhVar5;
        dh dhVar6;
        List list8;
        dh dhVar7;
        dh dhVar8;
        try {
            this.a.n();
            list = this.a.K;
            if (list != null) {
                list8 = this.a.K;
                if (list8.size() >= 200) {
                    dhVar7 = this.a.h;
                    dhVar7.c(0);
                    dhVar8 = this.a.h;
                    dhVar8.notifyDataSetChanged();
                    return;
                }
            }
            tVar = this.a.g;
            com.baidu.tieba.a.at a = tVar.a();
            tVar2 = this.a.g;
            if (tVar2 != null && a != null) {
                if (this.d == 1) {
                    this.a.J = a.e();
                }
                if (this.d == 2) {
                    this.a.I = a.e();
                }
                if (a.e() < a.c()) {
                    dhVar6 = this.a.h;
                    dhVar6.c(2);
                } else {
                    dhVar = this.a.h;
                    dhVar.c(0);
                }
                i = this.a.I;
                if (i > 1) {
                    dhVar5 = this.a.h;
                    dhVar5.b(2);
                } else {
                    dhVar2 = this.a.h;
                    dhVar2.b(0);
                }
                tVar3 = this.a.g;
                List b = tVar3.a().b();
                if (b != null && b.size() > 0) {
                    int size = b.size();
                    if (this.d == 3) {
                        list7 = this.a.K;
                        list7.addAll(b);
                    }
                    if (this.d == 1) {
                        list4 = this.a.K;
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
                                    list6 = this.a.K;
                                    if (a2.equals(((com.baidu.tieba.a.an) list6.get(i3)).a())) {
                                        z = true;
                                        break;
                                    }
                                    i3++;
                                }
                                if (!z) {
                                    list5 = this.a.K;
                                    list5.add((com.baidu.tieba.a.an) b.get(i2));
                                }
                            }
                        }
                    }
                    if (this.d == 2) {
                        list3 = this.a.K;
                        list3.addAll(0, b);
                    }
                    dhVar3 = this.a.h;
                    list2 = this.a.K;
                    dhVar3.a(list2);
                    dhVar4 = this.a.h;
                    dhVar4.notifyDataSetChanged();
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.e(getClass().getName(), "refreshActivity", e.getMessage());
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
        str = this.a.i;
        tVar.a("kz", str);
        z = this.a.r;
        if (!z) {
            com.baidu.tieba.c.t tVar2 = this.b;
            str5 = this.a.j;
            tVar2.a("pid", str5);
            this.b.a("pn", String.valueOf(this.c));
        } else {
            com.baidu.tieba.c.t tVar3 = this.b;
            str2 = this.a.j;
            tVar3.a("spid", str2);
        }
        str3 = this.a.m;
        if (str3 != null) {
            com.baidu.tieba.c.t tVar4 = this.b;
            str4 = this.a.m;
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
        com.baidu.tieba.b.t tVar;
        com.baidu.tieba.b.t tVar2;
        dh dhVar;
        com.baidu.tieba.b.t tVar3;
        super.onPostExecute(str);
        try {
            if (this.b != null) {
                if (this.b.b()) {
                    this.a.g = new com.baidu.tieba.b.t(this.a, str);
                    SubPbActivity subPbActivity = this.a;
                    tVar = this.a.g;
                    subPbActivity.k = tVar.a().f().b();
                    SubPbActivity subPbActivity2 = this.a;
                    tVar2 = this.a.g;
                    subPbActivity2.l = tVar2.a().f().c();
                    dhVar = this.a.h;
                    tVar3 = this.a.g;
                    dhVar.a(tVar3);
                    this.a.r = false;
                    this.a.p();
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
            com.baidu.tieba.c.af.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
        this.a.H = null;
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
        dh dhVar;
        dh dhVar2;
        dh dhVar3;
        dh dhVar4;
        dh dhVar5;
        dh dhVar6;
        dh dhVar7;
        dh dhVar8;
        ProgressBar progressBar2;
        progressBar = this.a.s;
        if (progressBar.getVisibility() == 0) {
            progressBar2 = this.a.s;
            progressBar2.setVisibility(8);
        }
        dhVar = this.a.h;
        if (dhVar.a()) {
            dhVar6 = this.a.h;
            dhVar6.b(false);
            dhVar7 = this.a.h;
            if (dhVar7.d()) {
                dhVar8 = this.a.h;
                dhVar8.notifyDataSetChanged();
            }
        }
        dhVar2 = this.a.h;
        if (dhVar2.b()) {
            dhVar3 = this.a.h;
            dhVar3.c(false);
            dhVar4 = this.a.h;
            if (dhVar4.c()) {
                dhVar5 = this.a.h;
                dhVar5.notifyDataSetInvalidated();
            }
        }
    }
}
