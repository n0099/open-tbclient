package com.baidu.tieba;

import com.baidu.tieba.data.NewErrorData;
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.tieba.util.am f2134a;
    protected NewErrorData b = null;

    public o() {
        this.f2134a = null;
        this.f2134a = new com.baidu.tieba.util.am();
    }

    public void a() {
        if (this.f2134a != null) {
            this.f2134a.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.f2134a.a(str);
    }

    public void a(String str, String str2) {
        this.f2134a.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        String l = this.f2134a.l();
        this.b = new NewErrorData();
        this.b.parserJson(l);
        return l;
    }

    public boolean c() {
        if (this.f2134a != null) {
            return this.f2134a.c();
        }
        return false;
    }

    public String d() {
        if (this.f2134a != null) {
            return this.f2134a.i();
        }
        return null;
    }

    public int e() {
        if (this.b != null) {
            return this.b.getErrorNumber();
        }
        return -1;
    }

    public String f() {
        if (this.b != null) {
            return this.b.getErrorMsg();
        }
        return null;
    }
}
