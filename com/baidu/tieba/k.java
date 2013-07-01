package com.baidu.tieba;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.util.r f948a;
    private com.baidu.tieba.data.ag b = null;

    public k() {
        this.f948a = null;
        this.f948a = new com.baidu.tieba.util.r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.f948a.a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a() {
        String j = this.f948a.j();
        this.b = new com.baidu.tieba.data.ag();
        this.b.a(j);
        return j;
    }

    public boolean b() {
        if (this.f948a != null) {
            return this.f948a.c();
        }
        return false;
    }

    public String c() {
        if (this.f948a != null) {
            return this.f948a.g();
        }
        return null;
    }
}
