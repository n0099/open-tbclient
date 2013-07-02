package com.baidu.tieba;
/* loaded from: classes.dex */
public class k {
    private com.baidu.tieba.util.r a;
    private com.baidu.tieba.data.ag b = null;

    public k() {
        this.a = null;
        this.a = new com.baidu.tieba.util.r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.a.a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a() {
        String j = this.a.j();
        this.b = new com.baidu.tieba.data.ag();
        this.b.a(j);
        return j;
    }

    public boolean b() {
        if (this.a != null) {
            return this.a.c();
        }
        return false;
    }

    public String c() {
        if (this.a != null) {
            return this.a.g();
        }
        return null;
    }
}
