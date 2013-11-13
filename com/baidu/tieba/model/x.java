package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.data.t f1953a;
    private y b = null;

    public x() {
        this.f1953a = null;
        this.f1953a = new com.baidu.tieba.data.t();
    }

    public com.baidu.tieba.data.t a() {
        return this.f1953a;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
            return false;
        }
        return false;
    }

    public void a(boolean z, boolean z2, boolean z3) {
        if (this.b == null) {
            this.b = new y(this, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
            this.b.setPriority(3);
            this.b.execute(new Object[0]);
        }
    }
}
