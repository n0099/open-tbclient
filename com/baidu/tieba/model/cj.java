package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class cj extends com.baidu.adp.a.d {
    private com.baidu.tieba.data.ba b;

    /* renamed from: a  reason: collision with root package name */
    private cl f1937a = null;
    private ck c = null;

    public cj() {
        this.b = null;
        this.b = new com.baidu.tieba.data.ba();
    }

    public com.baidu.tieba.data.ba a() {
        return this.b;
    }

    public void a(ck ckVar) {
        this.c = ckVar;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.f1937a != null) {
            this.f1937a.cancel();
            return false;
        }
        return false;
    }

    public boolean b() {
        if (this.f1937a != null) {
            return false;
        }
        this.f1937a = new cl(this, 1);
        this.f1937a.execute(new Object[0]);
        return true;
    }

    public boolean c() {
        if (this.f1937a != null) {
            return false;
        }
        this.f1937a = new cl(this, 0);
        this.f1937a.execute(new Object[0]);
        return true;
    }
}
