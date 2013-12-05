package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.a.d {
    private com.baidu.tieba.data.r b;

    /* renamed from: a  reason: collision with root package name */
    private v f2045a = null;
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
        if (this.f2045a != null) {
            this.f2045a.cancel();
            return false;
        }
        return false;
    }

    public boolean a(boolean z) {
        this.c = z;
        if (this.f2045a != null) {
            return false;
        }
        this.f2045a = new v(this, 1);
        this.f2045a.execute(new Object[0]);
        return true;
    }

    public boolean b(boolean z) {
        this.c = z;
        if (this.f2045a != null) {
            return false;
        }
        this.f2045a = new v(this, 0);
        this.f2045a.execute(new Object[0]);
        return true;
    }
}
