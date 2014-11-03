package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class l implements g {
    final /* synthetic */ SignAllForumActivity bLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.bLc = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.g
    public void a(b bVar) {
        ab abVar;
        ab abVar2;
        abVar = this.bLc.bKV;
        abVar.IR();
        com.baidu.tieba.home.t acB = bVar.acB();
        if (acB != null && acB.getErrorNumber() == 0) {
            abVar2 = this.bLc.bKV;
            abVar2.d(bVar);
            return;
        }
        this.bLc.showToast(acB.getUserMsg(), false);
        this.bLc.finish();
    }

    @Override // com.baidu.tieba.signall.g
    public void fw(String str) {
        ab abVar;
        abVar = this.bLc.bKV;
        abVar.IR();
        this.bLc.showToast(str, false);
        this.bLc.finish();
    }
}
