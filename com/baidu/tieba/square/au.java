package com.baidu.tieba.square;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.base.d {
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

    public long a() {
        return this.g;
    }

    public long b() {
        return this.e;
    }

    public long c() {
        return this.f;
    }

    public long d() {
        return this.d;
    }

    public aq e() {
        return this.b;
    }

    public void a(av avVar) {
        this.c = avVar;
    }

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return false;
        }
        return false;
    }

    public boolean f() {
        return a(1);
    }

    public boolean g() {
        return a(0);
    }

    public boolean a(int i) {
        if (this.a != null) {
            return false;
        }
        this.a = new aw(this, i);
        this.a.execute(new Object[0]);
        return true;
    }
}
