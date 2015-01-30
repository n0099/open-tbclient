package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class l implements g {
    final /* synthetic */ SignAllForumActivity bRc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.bRc = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.g
    public void a(b bVar) {
        ad adVar;
        ad adVar2;
        adVar = this.bRc.bQV;
        adVar.JI();
        com.baidu.tieba.home.t adA = bVar.adA();
        if (adA != null && adA.getErrorNumber() == 0) {
            adVar2 = this.bRc.bQV;
            adVar2.d(bVar);
            return;
        }
        this.bRc.showToast(adA.getUserMsg(), false);
        this.bRc.finish();
    }

    @Override // com.baidu.tieba.signall.g
    public void gK(String str) {
        ad adVar;
        adVar = this.bRc.bQV;
        adVar.JI();
        this.bRc.showToast(str, false);
        this.bRc.finish();
    }
}
