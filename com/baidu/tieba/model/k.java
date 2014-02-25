package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.a.d {
    private com.baidu.tieba.data.s b;
    private m a = null;
    private boolean c = true;
    private n d = null;

    public k() {
        this.b = null;
        this.b = new com.baidu.tieba.data.s();
    }

    public com.baidu.tieba.data.s a() {
        return this.b;
    }

    public void a(n nVar) {
        this.d = nVar;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return false;
        }
        return false;
    }

    public boolean a(boolean z) {
        this.c = z;
        if (this.a != null) {
            return false;
        }
        this.a = new m(this, 1);
        this.a.execute(new Object[0]);
        return true;
    }

    public boolean b(boolean z) {
        this.c = z;
        if (this.a != null) {
            return false;
        }
        this.a = new m(this, 0);
        this.a.execute(new Object[0]);
        return true;
    }
}
