package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.b {
    private com.baidu.tieba.data.n b;
    private q a = null;
    private boolean c = true;
    private r d = null;
    private long e = 0;
    private long f = 0;
    private long g = 0;
    private long h = 0;

    public o() {
        this.b = null;
        this.b = new com.baidu.tieba.data.n();
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

    public com.baidu.tieba.data.n e() {
        return this.b;
    }

    public void a(r rVar) {
        this.d = rVar;
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
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
        this.a = new q(this, 1);
        this.a.execute(new Object[0]);
        return true;
    }

    public boolean b(boolean z) {
        this.c = z;
        if (this.a != null) {
            return false;
        }
        this.a = new q(this, 0);
        this.a.execute(new Object[0]);
        return true;
    }
}
