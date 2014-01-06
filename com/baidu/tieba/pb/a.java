package com.baidu.tieba.pb;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList<String> a;
    private String d;
    private String e;
    private String f;
    private boolean k;
    private String b = null;
    private String c = null;
    private boolean g = false;
    private b h = null;
    private int i = 0;
    private boolean j = false;
    private c l = null;

    public a(ArrayList<String> arrayList, String str, String str2, String str3) {
        this.a = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.k = false;
        this.a = arrayList;
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
        this.d = str2;
        this.e = str;
        this.f = str3;
        if (this.f == null) {
            this.k = true;
        }
    }

    public void a() {
        if (!this.g && !this.k) {
            a(this.d, this.f, 10, 0);
        }
    }

    public void b() {
        if (!this.k) {
            if (!this.g) {
                a();
            } else if (this.b != null && this.b.length() > 0) {
                a(this.b, null, 0, 10);
            }
        }
    }

    private void a(String str, String str2, int i, int i2) {
        if (this.h != null) {
            if (str2 == null || !str2.equals(this.h.d())) {
                this.h.cancel();
            } else {
                return;
            }
        }
        this.h = new b(this, str, str2, i, i2);
        this.h.setPriority(3);
        this.h.execute(new Object[0]);
    }

    public void a(c cVar) {
        this.l = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(com.baidu.tieba.data.ab abVar) {
        if (abVar.j() != null && abVar.j().length() > 0) {
            return abVar.j();
        }
        StringBuilder sb = new StringBuilder(150);
        if (abVar.g() * abVar.f() > com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i()) {
            double sqrt = Math.sqrt((com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i()) / (abVar.g() * abVar.f()));
            sb.append("width=");
            sb.append(String.valueOf((int) (abVar.f() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (sqrt * abVar.g())));
        } else {
            sb.append("width=");
            sb.append(String.valueOf(abVar.f()));
            sb.append("&height=");
            sb.append(String.valueOf(abVar.g()));
        }
        sb.append("&src=");
        sb.append(com.baidu.tieba.util.bm.d(abVar.b()));
        return sb.toString();
    }
}
