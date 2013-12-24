package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.a.d {
    private com.baidu.tieba.data.r b;
    private v a = null;
    private boolean c = true;
    private w d = null;

    public t() {
        this.b = null;
        this.b = new com.baidu.tieba.data.r();
    }

    public com.baidu.tieba.data.r a() {
        return this.b;
    }

    public void a(w wVar) {
        this.d = wVar;
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
        this.a = new v(this, 1);
        this.a.execute(new Object[0]);
        return true;
    }

    public boolean b(boolean z) {
        this.c = z;
        if (this.a != null) {
            return false;
        }
        this.a = new v(this, 0);
        this.a.execute(new Object[0]);
        return true;
    }
}
