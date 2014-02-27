package com.baidu.tieba.model;
/* loaded from: classes.dex */
public final class k extends com.baidu.adp.a.d {
    private com.baidu.tieba.data.s b;
    private m a = null;
    private boolean c = true;
    private n d = null;
    private long e = 0;
    private long f = 0;
    private long g = 0;
    private long h = 0;

    public k() {
        this.b = null;
        this.b = new com.baidu.tieba.data.s();
    }

    public final long a() {
        return this.h;
    }

    public final long b() {
        return this.f;
    }

    public final long c() {
        return this.g;
    }

    public final long d() {
        return this.e;
    }

    public final com.baidu.tieba.data.s e() {
        return this.b;
    }

    public final void a(n nVar) {
        this.d = nVar;
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return false;
        }
        return false;
    }

    public final boolean a(boolean z) {
        this.c = z;
        if (this.a != null) {
            return false;
        }
        this.a = new m(this, 1);
        this.a.execute(new Object[0]);
        return true;
    }

    public final boolean b(boolean z) {
        this.c = z;
        if (this.a != null) {
            return false;
        }
        this.a = new m(this, 0);
        this.a.execute(new Object[0]);
        return true;
    }
}
