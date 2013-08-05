package com.baidu.tieba;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.tieba.util.u f1172a;
    protected com.baidu.tieba.data.ao b = null;

    public k() {
        this.f1172a = null;
        this.f1172a = new com.baidu.tieba.util.u();
    }

    public void a() {
        if (this.f1172a != null) {
            this.f1172a.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.f1172a.a(str);
    }

    public void a(String str, String str2) {
        this.f1172a.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        String k = this.f1172a.k();
        this.b = new com.baidu.tieba.data.ao();
        this.b.a(k);
        return k;
    }

    public boolean c() {
        if (this.f1172a != null) {
            return this.f1172a.d();
        }
        return false;
    }

    public String d() {
        if (this.f1172a != null) {
            return this.f1172a.h();
        }
        return null;
    }

    public int e() {
        if (this.b != null) {
            return this.b.a();
        }
        return -1;
    }

    public String f() {
        if (this.b != null) {
            return this.b.b();
        }
        return null;
    }
}
