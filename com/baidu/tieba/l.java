package com.baidu.tieba;

import com.baidu.tieba.data.NewErrorData;
/* loaded from: classes.dex */
public class l {
    protected com.baidu.tieba.util.ba a;
    protected NewErrorData b = null;

    public l() {
        this.a = null;
        this.a = new com.baidu.tieba.util.ba();
    }

    public void a() {
        if (this.a != null) {
            this.a.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str) {
        this.a.a(str);
    }

    public final void a(String str, String str2) {
        this.a.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        String l = this.a.l();
        this.b = new NewErrorData();
        this.b.parserJson(l);
        return l;
    }

    public final boolean c() {
        if (this.a != null) {
            return this.a.c();
        }
        return false;
    }

    public final String d() {
        if (this.a != null) {
            return this.a.i();
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
