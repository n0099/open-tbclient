package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.data.t f1452a;
    private q b = null;

    public p() {
        this.f1452a = null;
        this.f1452a = new com.baidu.tieba.data.t();
    }

    public com.baidu.tieba.data.t a() {
        return this.f1452a;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
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
            this.b = new q(this, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
            this.b.setPriority(3);
            this.b.execute(new Object[0]);
        }
    }
}
