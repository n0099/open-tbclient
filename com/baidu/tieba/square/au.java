package com.baidu.tieba.square;
/* loaded from: classes.dex */
public final class au extends com.baidu.adp.a.e {
    private aq b;
    private aw a = null;
    private av c = null;
    private long d = 0;
    private long e = 0;
    private long f = 0;
    private long g = 0;

    public au() {
        this.b = null;
        this.b = new aq();
    }

    public final long a() {
        return this.g;
    }

    public final long b() {
        return this.e;
    }

    public final long c() {
        return this.f;
    }

    public final long d() {
        return this.d;
    }

    public final aq e() {
        return this.b;
    }

    public final void a(av avVar) {
        this.c = avVar;
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

    public final boolean a(int i) {
        if (this.a != null) {
            return false;
        }
        this.a = new aw(this, i);
        this.a.execute(new Object[0]);
        return true;
    }
}
