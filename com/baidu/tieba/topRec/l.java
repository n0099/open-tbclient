package com.baidu.tieba.topRec;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    n f2455a;
    o b;
    private boolean c = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public boolean LoadData() {
        this.f2455a = new n(this);
        this.f2455a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.f2455a != null) {
            this.f2455a.cancel();
            return false;
        }
        return false;
    }

    public void a(o oVar) {
        this.b = oVar;
    }
}
