package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    n f2396a;
    o b;
    private boolean c = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public boolean LoadData() {
        this.f2396a = new n(this);
        this.f2396a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.f2396a != null) {
            this.f2396a.cancel();
            return false;
        }
        return false;
    }

    public void a(o oVar) {
        this.b = oVar;
    }
}
