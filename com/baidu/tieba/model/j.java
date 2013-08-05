package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.c {
    private com.baidu.tieba.data.q b;

    /* renamed from: a  reason: collision with root package name */
    private k f1374a = null;
    private boolean c = true;
    private l d = null;

    public j() {
        this.b = null;
        this.b = new com.baidu.tieba.data.q();
    }

    public com.baidu.tieba.data.q a() {
        return this.b;
    }

    public void a(l lVar) {
        this.d = lVar;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.f1374a != null) {
            this.f1374a.cancel();
            return false;
        }
        return false;
    }

    public boolean a(boolean z) {
        this.c = z;
        if (this.f1374a != null) {
            return false;
        }
        this.f1374a = new k(this, 1);
        this.f1374a.execute(new Object[0]);
        return true;
    }

    public boolean b(boolean z) {
        this.c = z;
        if (this.f1374a != null) {
            return false;
        }
        this.f1374a = new k(this, 0);
        this.f1374a.execute(new Object[0]);
        return true;
    }
}
