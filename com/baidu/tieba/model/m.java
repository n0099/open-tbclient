package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.data.p f1057a;
    private n b = null;

    public m() {
        this.f1057a = null;
        this.f1057a = new com.baidu.tieba.data.p();
    }

    public com.baidu.tieba.data.p a() {
        return this.f1057a;
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
            this.b = new n(this, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
            this.b.setPriority(3);
            this.b.execute(new Object[0]);
        }
    }
}
