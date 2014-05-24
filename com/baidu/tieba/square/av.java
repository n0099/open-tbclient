package com.baidu.tieba.square;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.base.b {
    private ar b;
    private ax a = null;
    private aw c = null;
    private long d = 0;
    private long e = 0;
    private long f = 0;
    private long g = 0;

    public av() {
        this.b = null;
        this.b = new ar();
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

    public ar e() {
        return this.b;
    }

    public void a(aw awVar) {
        this.c = awVar;
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
        this.a = new ax(this, i);
        this.a.execute(new Object[0]);
        return true;
    }
}
