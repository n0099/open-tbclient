package com.baidu.tieba;

import com.baidu.tieba.data.NewErrorData;
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.tieba.util.am f2135a;
    protected NewErrorData b = null;

    public o() {
        this.f2135a = null;
        this.f2135a = new com.baidu.tieba.util.am();
    }

    public void a() {
        if (this.f2135a != null) {
            this.f2135a.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.f2135a.a(str);
    }

    public void a(String str, String str2) {
        this.f2135a.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        String l = this.f2135a.l();
        this.b = new NewErrorData();
        this.b.parserJson(l);
        return l;
    }

    public boolean c() {
        if (this.f2135a != null) {
            return this.f2135a.c();
        }
        return false;
    }

    public String d() {
        if (this.f2135a != null) {
            return this.f2135a.i();
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
