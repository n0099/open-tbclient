package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.a.d {
    n a;
    o b;
    private boolean c = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public boolean LoadData() {
        this.a = new n(this);
        this.a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return false;
        }
        return false;
    }

    public void a(o oVar) {
        this.b = oVar;
    }
}
