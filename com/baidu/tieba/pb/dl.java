package com.baidu.tieba.pb;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dl extends AsyncTask {
    final /* synthetic */ SubPbActivity a;
    private com.baidu.tieba.c.t b = null;
    private int c;
    private int d;

    public dl(SubPbActivity subPbActivity, int i) {
        int i2;
        com.baidu.tieba.b.v vVar;
        int i3;
        com.baidu.tieba.b.v vVar2;
        com.baidu.tieba.b.v vVar3;
        int i4;
        int i5;
        this.a = subPbActivity;
        this.c = 0;
        this.d = 3;
        this.d = i;
        switch (i) {
            case 1:
                vVar = subPbActivity.g;
                if (vVar != null) {
                    vVar2 = subPbActivity.g;
                    if (vVar2.a() != null) {
                        vVar3 = subPbActivity.g;
                        int c = vVar3.a().c();
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
        com.baidu.tieba.b.v vVar;
        com.baidu.tieba.b.v vVar2;
        dm dmVar;
        int i;
        dm dmVar2;
        com.baidu.tieba.b.v vVar3;
        dm dmVar3;
        List list2;
        dm dmVar4;
        List list3;
        List list4;
        boolean z;
        List list5;
        List list6;
        List list7;
        dm dmVar5;
        dm dmVar6;
        List list8;
        dm dmVar7;
        dm dmVar8;
        try {
            this.a.n();
            list = this.a.K;
            if (list != null) {
                list8 = this.a.K;
                if (list8.size() >= 200) {
                    dmVar7 = this.a.h;
                    dmVar7.c(0);
                    dmVar8 = this.a.h;
                    dmVar8.notifyDataSetChanged();
                    return;
                }
            }
            vVar = this.a.g;
            com.baidu.tieba.a.ar a = vVar.a();
            vVar2 = this.a.g;
            if (vVar2 != null && a != null) {
                if (this.d == 1) {
                    this.a.J = a.e();
                }
                if (this.d == 2) {
                    this.a.I = a.e();
                }
                if (a.e() < a.c()) {
                    dmVar6 = this.a.h;
                    dmVar6.c(2);
                } else {
                    dmVar = this.a.h;
                    dmVar.c(0);
                }
                i = this.a.I;
                if (i > 1) {
                    dmVar5 = this.a.h;
                    dmVar5.b(2);
                } else {
                    dmVar2 = this.a.h;
                    dmVar2.b(0);
                }
                vVar3 = this.a.g;
                List b = vVar3.a().b();
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
                            String a2 = ((com.baidu.tieba.a.al) b.get(i2)).a();
                            if (a2 != null) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= size2) {
                                        z = false;
                                        break;
                                    }
                                    list6 = this.a.K;
                                    if (a2.equals(((com.baidu.tieba.a.al) list6.get(i3)).a())) {
                                        z = true;
                                        break;
                                    }
                                    i3++;
                                }
                                if (!z) {
                                    list5 = this.a.K;
                                    list5.add((com.baidu.tieba.a.al) b.get(i2));
                                }
                            }
                        }
                    }
                    if (this.d == 2) {
                        list3 = this.a.K;
                        list3.addAll(0, b);
                    }
                    dmVar3 = this.a.h;
                    list2 = this.a.K;
                    dmVar3.a(list2);
                    dmVar4 = this.a.h;
                    dmVar4.notifyDataSetChanged();
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
        com.baidu.tieba.b.v vVar;
        com.baidu.tieba.b.v vVar2;
        dm dmVar;
        com.baidu.tieba.b.v vVar3;
        super.onPostExecute(str);
        try {
            if (this.b != null) {
                if (this.b.b()) {
                    this.a.g = new com.baidu.tieba.b.v(this.a, str);
                    SubPbActivity subPbActivity = this.a;
                    vVar = this.a.g;
                    subPbActivity.k = vVar.a().f().b();
                    SubPbActivity subPbActivity2 = this.a;
                    vVar2 = this.a.g;
                    subPbActivity2.l = vVar2.a().f().c();
                    dmVar = this.a.h;
                    vVar3 = this.a.g;
                    dmVar.a(vVar3);
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
            com.baidu.tieba.c.ag.b(getClass().getName(), "onPostExecute", e.getMessage());
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
        dm dmVar;
        dm dmVar2;
        dm dmVar3;
        dm dmVar4;
        dm dmVar5;
        dm dmVar6;
        dm dmVar7;
        dm dmVar8;
        ProgressBar progressBar2;
        progressBar = this.a.s;
        if (progressBar.getVisibility() == 0) {
            progressBar2 = this.a.s;
            progressBar2.setVisibility(8);
        }
        dmVar = this.a.h;
        if (dmVar.a()) {
            dmVar6 = this.a.h;
            dmVar6.b(false);
            dmVar7 = this.a.h;
            if (dmVar7.d()) {
                dmVar8 = this.a.h;
                dmVar8.notifyDataSetChanged();
            }
        }
        dmVar2 = this.a.h;
        if (dmVar2.b()) {
            dmVar3 = this.a.h;
            dmVar3.c(false);
            dmVar4 = this.a.h;
            if (dmVar4.c()) {
                dmVar5 = this.a.h;
                dmVar5.notifyDataSetInvalidated();
            }
        }
    }
}
