package com.baidu.tieba;

import com.baidu.tieba.data.NewErrorData;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.tieba.util.ap f2026a;
    protected NewErrorData b = null;

    public n() {
        this.f2026a = null;
        this.f2026a = new com.baidu.tieba.util.ap();
    }

    public void a() {
        if (this.f2026a != null) {
            this.f2026a.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.f2026a.a(str);
    }

    public void a(String str, String str2) {
        this.f2026a.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        String j = this.f2026a.j();
        this.b = new NewErrorData();
        this.b.parserJson(j);
        return j;
    }

    public boolean c() {
        if (this.f2026a != null) {
            return this.f2026a.c();
        }
        return false;
    }

    public String d() {
        if (this.f2026a != null) {
            return this.f2026a.g();
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
