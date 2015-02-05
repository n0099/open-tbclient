package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class l implements g {
    final /* synthetic */ SignAllForumActivity bRb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.bRb = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.g
    public void a(b bVar) {
        ad adVar;
        ad adVar2;
        adVar = this.bRb.bQU;
        adVar.JD();
        com.baidu.tieba.home.t adv = bVar.adv();
        if (adv != null && adv.getErrorNumber() == 0) {
            adVar2 = this.bRb.bQU;
            adVar2.d(bVar);
            return;
        }
        this.bRb.showToast(adv.getUserMsg(), false);
        this.bRb.finish();
    }

    @Override // com.baidu.tieba.signall.g
    public void gH(String str) {
        ad adVar;
        adVar = this.bRb.bQU;
        adVar.JD();
        this.bRb.showToast(str, false);
        this.bRb.finish();
    }
}
