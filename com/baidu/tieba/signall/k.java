package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class k implements g {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.g
    public void a(b bVar) {
        aa aaVar;
        aa aaVar2;
        aaVar = this.a.a;
        aaVar.b();
        com.baidu.tieba.home.r j = bVar.j();
        if (j != null && j.a() == 0) {
            aaVar2 = this.a.a;
            aaVar2.a(bVar);
            return;
        }
        this.a.showToast(j.b(), false);
        this.a.finish();
    }

    @Override // com.baidu.tieba.signall.g
    public void a(String str) {
        aa aaVar;
        aaVar = this.a.a;
        aaVar.b();
        this.a.showToast(str, false);
        this.a.finish();
    }
}
