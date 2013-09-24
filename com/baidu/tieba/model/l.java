package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.a.c {
    private com.baidu.tieba.data.q b;

    /* renamed from: a  reason: collision with root package name */
    private n f1449a = null;
    private boolean c = true;
    private o d = null;

    public l() {
        this.b = null;
        this.b = new com.baidu.tieba.data.q();
    }

    public com.baidu.tieba.data.q a() {
        return this.b;
    }

    public void a(o oVar) {
        this.d = oVar;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.f1449a != null) {
            this.f1449a.cancel();
            return false;
        }
        return false;
    }

    public boolean a(boolean z) {
        this.c = z;
        if (this.f1449a != null) {
            return false;
        }
        this.f1449a = new n(this, 1);
        this.f1449a.execute(new Object[0]);
        return true;
    }

    public boolean b(boolean z) {
        this.c = z;
        if (this.f1449a != null) {
            return false;
        }
        this.f1449a = new n(this, 0);
        this.f1449a.execute(new Object[0]);
        return true;
    }
}
