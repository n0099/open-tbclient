package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    m f1874a;
    n b;
    private boolean c = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.c
    public boolean LoadData() {
        this.f1874a = new m(this, null);
        this.f1874a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.f1874a != null) {
            this.f1874a.cancel();
            return false;
        }
        return false;
    }

    public void a(n nVar) {
        this.b = nVar;
    }
}
