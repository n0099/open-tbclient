package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.e {
    l a;
    m b;
    private boolean c = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        this.a = new l(this, null);
        this.a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return false;
        }
        return false;
    }

    public void a(m mVar) {
        this.b = mVar;
    }
}
