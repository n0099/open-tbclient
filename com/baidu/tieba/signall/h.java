package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class h implements e {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.e
    public void a(a aVar) {
        x xVar;
        x xVar2;
        xVar = this.a.a;
        xVar.b();
        com.baidu.tieba.home.r k = aVar.k();
        if (k != null && k.a() == 0) {
            xVar2 = this.a.a;
            xVar2.a(aVar);
            return;
        }
        this.a.showToast(k.b(), false);
        this.a.finish();
    }

    @Override // com.baidu.tieba.signall.e
    public void a(String str) {
        x xVar;
        xVar = this.a.a;
        xVar.b();
        this.a.showToast(str, false);
        this.a.finish();
    }
}
