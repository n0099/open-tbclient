package com.baidu.tieba.square;
/* loaded from: classes.dex */
public final class aw extends com.baidu.adp.a.d {
    private as b;
    private ay a = null;
    private ax c = null;
    private long d = 0;
    private long e = 0;
    private long f = 0;
    private long g = 0;

    public aw() {
        this.b = null;
        this.b = new as();
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

    public final as e() {
        return this.b;
    }

    public final void a(ax axVar) {
        this.c = axVar;
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

    public final boolean a(int i) {
        if (this.a != null) {
            return false;
        }
        this.a = new ay(this, i);
        this.a.execute(new Object[0]);
        return true;
    }
}
