package com.baidu.tieba.pb;

import com.baidu.zeus.WebChromeClient;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    private ArrayList a;
    private String d;
    private String e;
    private String f;
    private boolean k;
    private String b = null;
    private String c = null;
    private boolean g = false;
    private e h = null;
    private int i = 0;
    private boolean j = false;
    private f l = null;

    public d(ArrayList arrayList, String str, String str2, String str3) {
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
            if (str2 == null || !str2.equals(this.h.a())) {
                this.h.b();
            } else {
                return;
            }
        }
        this.h = new e(this, str, str2, i, i2);
        this.h.execute(new Object[0]);
    }

    public void a(f fVar) {
        this.l = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(com.baidu.tieba.a.u uVar) {
        StringBuffer stringBuffer = new StringBuffer((int) WebChromeClient.STRING_DLG_BTN_SET);
        if (uVar.g() * uVar.f() > com.baidu.tieba.a.i.g() * com.baidu.tieba.a.i.g()) {
            double sqrt = Math.sqrt((com.baidu.tieba.a.i.g() * com.baidu.tieba.a.i.g()) / (uVar.g() * uVar.f()));
            stringBuffer.append("width=");
            stringBuffer.append(String.valueOf((int) (uVar.f() * sqrt)));
            stringBuffer.append("&height=");
            stringBuffer.append(String.valueOf((int) (sqrt * uVar.g())));
        } else {
            stringBuffer.append("width=");
            stringBuffer.append(String.valueOf(uVar.f()));
            stringBuffer.append("&height=");
            stringBuffer.append(String.valueOf(uVar.g()));
        }
        stringBuffer.append("&src=");
        stringBuffer.append(com.baidu.tieba.c.af.f(uVar.b()));
        return stringBuffer.toString();
    }
}
