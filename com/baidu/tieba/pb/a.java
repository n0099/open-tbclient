package com.baidu.tieba.pb;

import com.baidu.zeus.WebChromeClient;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList a;
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

    public a(ArrayList arrayList, String str, String str2, String str3) {
        this.a = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.k = false;
        this.a = arrayList;
        if (this.a == null) {
            this.a = new ArrayList();
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
            if (str2 == null || !str2.equals(this.h.e())) {
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
    public String a(com.baidu.tieba.a.w wVar) {
        StringBuilder sb = new StringBuilder((int) WebChromeClient.STRING_DLG_BTN_SET);
        if (wVar.g() * wVar.f() > com.baidu.tieba.a.i.h() * com.baidu.tieba.a.i.h()) {
            double sqrt = Math.sqrt((com.baidu.tieba.a.i.h() * com.baidu.tieba.a.i.h()) / (wVar.g() * wVar.f()));
            sb.append("width=");
            sb.append(String.valueOf((int) (wVar.f() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (sqrt * wVar.g())));
        } else {
            sb.append("width=");
            sb.append(String.valueOf(wVar.f()));
            sb.append("&height=");
            sb.append(String.valueOf(wVar.g()));
        }
        sb.append("&src=");
        sb.append(com.baidu.tieba.d.ad.d(wVar.b()));
        return sb.toString();
    }
}
