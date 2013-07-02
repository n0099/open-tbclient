package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.a.c {
    com.baidu.tieba.data.p a;
    private n b = null;

    public m() {
        this.a = null;
        this.a = new com.baidu.tieba.data.p();
    }

    public com.baidu.tieba.data.p a() {
        return this.a;
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
