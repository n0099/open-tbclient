package com.baidu.tieba.square;
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.base.e {
    private am b;
    private as a = null;
    private ar c = null;
    private long d = 0;
    private long e = 0;
    private long f = 0;
    private long g = 0;

    public aq() {
        this.b = null;
        this.b = new am();
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

    public am e() {
        return this.b;
    }

    public void a(ar arVar) {
        this.c = arVar;
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
        this.a = new as(this, i);
        this.a.execute(new Object[0]);
        return true;
    }
}
