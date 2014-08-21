package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class l implements g {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.g
    public void a(b bVar) {
        ab abVar;
        ab abVar2;
        abVar = this.a.a;
        abVar.b();
        com.baidu.tieba.home.r j = bVar.j();
        if (j != null && j.a() == 0) {
            abVar2 = this.a.a;
            abVar2.a(bVar);
            return;
        }
        this.a.showToast(j.b(), false);
        this.a.finish();
    }

    @Override // com.baidu.tieba.signall.g
    public void a(String str) {
        ab abVar;
        abVar = this.a.a;
        abVar.b();
        this.a.showToast(str, false);
        this.a.finish();
    }
}
