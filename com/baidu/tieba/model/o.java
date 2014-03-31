package com.baidu.tieba.model;
/* loaded from: classes.dex */
public final class o extends com.baidu.adp.a.e {
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

    public final com.baidu.tieba.data.n e() {
        return this.b;
    }

    public final void a(r rVar) {
        this.d = rVar;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
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
        this.a = new q(this, 1);
        this.a.execute(new Object[0]);
        return true;
    }

    public final boolean b(boolean z) {
        this.c = z;
        if (this.a != null) {
            return false;
        }
        this.a = new q(this, 0);
        this.a.execute(new Object[0]);
        return true;
    }
}
