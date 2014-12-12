package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class l implements g {
    final /* synthetic */ SignAllForumActivity bPs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.bPs = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.g
    public void a(b bVar) {
        ad adVar;
        ad adVar2;
        adVar = this.bPs.bPl;
        adVar.Jm();
        com.baidu.tieba.home.u acW = bVar.acW();
        if (acW != null && acW.getErrorNumber() == 0) {
            adVar2 = this.bPs.bPl;
            adVar2.d(bVar);
            return;
        }
        this.bPs.showToast(acW.getUserMsg(), false);
        this.bPs.finish();
    }

    @Override // com.baidu.tieba.signall.g
    public void gF(String str) {
        ad adVar;
        adVar = this.bPs.bPl;
        adVar.Jm();
        this.bPs.showToast(str, false);
        this.bPs.finish();
    }
}
