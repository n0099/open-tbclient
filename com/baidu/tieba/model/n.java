package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.e {
    private com.baidu.tieba.data.o b;
    private p a = null;
    private boolean c = true;
    private q d = null;
    private long e = 0;
    private long f = 0;
    private long g = 0;
    private long h = 0;

    public n() {
        this.b = null;
        this.b = new com.baidu.tieba.data.o();
    }

    public long a() {
        return this.h;
    }

    public long b() {
        return this.f;
    }

    public long c() {
        return this.g;
    }

    public long d() {
        return this.e;
    }

    public com.baidu.tieba.data.o e() {
        return this.b;
    }

    public void a(q qVar) {
        this.d = qVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return false;
        }
        return false;
    }

    public boolean a(boolean z) {
        this.c = z;
        if (this.a != null) {
            return false;
        }
        this.a = new p(this, 1);
        this.a.execute(new Object[0]);
        return true;
    }

    public boolean b(boolean z) {
        this.c = z;
        if (this.a != null) {
            return false;
        }
        this.a = new p(this, 0);
        this.a.execute(new Object[0]);
        return true;
    }
}
