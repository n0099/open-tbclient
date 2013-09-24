package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class bz extends com.baidu.adp.a.c {
    private com.baidu.tieba.data.bc b;

    /* renamed from: a  reason: collision with root package name */
    private cb f1433a = null;
    private ca c = null;

    public bz() {
        this.b = null;
        this.b = new com.baidu.tieba.data.bc();
    }

    public com.baidu.tieba.data.bc a() {
        return this.b;
    }

    public void a(ca caVar) {
        this.c = caVar;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.f1433a != null) {
            this.f1433a.cancel();
            return false;
        }
        return false;
    }

    public boolean b() {
        if (this.f1433a != null) {
            return false;
        }
        this.f1433a = new cb(this, 1);
        this.f1433a.execute(new Object[0]);
        return true;
    }

    public boolean c() {
        if (this.f1433a != null) {
            return false;
        }
        this.f1433a = new cb(this, 0);
        this.f1433a.execute(new Object[0]);
        return true;
    }
}
