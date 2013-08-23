package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class bx extends com.baidu.adp.a.c {
    private com.baidu.tieba.data.bc b;

    /* renamed from: a  reason: collision with root package name */
    private bz f1396a = null;
    private by c = null;

    public bx() {
        this.b = null;
        this.b = new com.baidu.tieba.data.bc();
    }

    public com.baidu.tieba.data.bc a() {
        return this.b;
    }

    public void a(by byVar) {
        this.c = byVar;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.f1396a != null) {
            this.f1396a.cancel();
            return false;
        }
        return false;
    }

    public boolean b() {
        if (this.f1396a != null) {
            return false;
        }
        this.f1396a = new bz(this, 1);
        this.f1396a.execute(new Object[0]);
        return true;
    }

    public boolean c() {
        if (this.f1396a != null) {
            return false;
        }
        this.f1396a = new bz(this, 0);
        this.f1396a.execute(new Object[0]);
        return true;
    }
}
