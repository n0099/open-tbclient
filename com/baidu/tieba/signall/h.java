package com.baidu.tieba.signall;
/* loaded from: classes.dex */
final class h implements e {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.e
    public final void a(a aVar) {
        y yVar;
        y yVar2;
        yVar = this.a.a;
        yVar.d();
        com.baidu.tieba.home.q k = aVar.k();
        if (k != null && k.a() == 0) {
            yVar2 = this.a.a;
            yVar2.a(aVar);
            return;
        }
        this.a.showToast(k.b());
        this.a.finish();
    }

    @Override // com.baidu.tieba.signall.e
    public final void a(String str) {
        this.a.showToast(str);
        this.a.finish();
    }
}
