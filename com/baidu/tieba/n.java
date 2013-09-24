package com.baidu.tieba;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.tieba.util.z f1510a;
    protected com.baidu.tieba.data.ak b = null;

    public n() {
        this.f1510a = null;
        this.f1510a = new com.baidu.tieba.util.z();
    }

    public void a() {
        if (this.f1510a != null) {
            this.f1510a.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.f1510a.a(str);
    }

    public void a(String str, String str2) {
        this.f1510a.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        String j = this.f1510a.j();
        this.b = new com.baidu.tieba.data.ak();
        this.b.a(j);
        return j;
    }

    public boolean c() {
        if (this.f1510a != null) {
            return this.f1510a.c();
        }
        return false;
    }

    public String d() {
        if (this.f1510a != null) {
            return this.f1510a.g();
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
