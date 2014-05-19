package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.d {
    m a;
    n b;
    private boolean c = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.d
    public boolean LoadData() {
        this.a = new m(this, null);
        this.a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return false;
        }
        return false;
    }

    public void a(n nVar) {
        this.b = nVar;
    }
}
