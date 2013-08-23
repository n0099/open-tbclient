package com.baidu.tieba;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.tieba.util.v f1202a;
    protected com.baidu.tieba.data.ak b = null;

    public k() {
        this.f1202a = null;
        this.f1202a = new com.baidu.tieba.util.v();
    }

    public void a() {
        if (this.f1202a != null) {
            this.f1202a.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.f1202a.a(str);
    }

    public void a(String str, String str2) {
        this.f1202a.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        String j = this.f1202a.j();
        this.b = new com.baidu.tieba.data.ak();
        this.b.a(j);
        return j;
    }

    public boolean c() {
        if (this.f1202a != null) {
            return this.f1202a.c();
        }
        return false;
    }

    public String d() {
        if (this.f1202a != null) {
            return this.f1202a.g();
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
