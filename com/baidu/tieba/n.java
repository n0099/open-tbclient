package com.baidu.tieba;

import com.baidu.tieba.data.NewErrorData;
/* loaded from: classes.dex */
public class n {
    protected com.baidu.tieba.util.ax a;
    protected NewErrorData b = null;

    public n() {
        this.a = null;
        this.a = new com.baidu.tieba.util.ax();
    }

    public void a() {
        if (this.a != null) {
            this.a.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.a.a(str);
    }

    public void a(String str, String str2) {
        this.a.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        String m = this.a.m();
        this.b = new NewErrorData();
        this.b.parserJson(m);
        return m;
    }

    public boolean c() {
        if (this.a != null) {
            return this.a.d();
        }
        return false;
    }

    public String d() {
        if (this.a != null) {
            return this.a.j();
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
