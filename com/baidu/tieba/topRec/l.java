package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
public final class l extends com.baidu.adp.a.d {
    m a;
    n b;
    private boolean c = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public final boolean LoadData() {
        this.a = new m(this, (byte) 0);
        this.a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return false;
        }
        return false;
    }
}
