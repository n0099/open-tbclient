package com.baidu.tieba;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.tieba.util.ag f2027a;
    protected com.baidu.tieba.data.ak b = null;

    public n() {
        this.f2027a = null;
        this.f2027a = new com.baidu.tieba.util.ag();
    }

    public void a() {
        if (this.f2027a != null) {
            this.f2027a.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.f2027a.a(str);
    }

    public void a(String str, String str2) {
        this.f2027a.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        String j = this.f2027a.j();
        this.b = new com.baidu.tieba.data.ak();
        this.b.a(j);
        return j;
    }

    public boolean c() {
        if (this.f2027a != null) {
            return this.f2027a.c();
        }
        return false;
    }

    public String d() {
        if (this.f2027a != null) {
            return this.f2027a.g();
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
