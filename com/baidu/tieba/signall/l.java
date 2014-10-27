package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class l implements g {
    final /* synthetic */ SignAllForumActivity bKN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.bKN = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.g
    public void a(b bVar) {
        ab abVar;
        ab abVar2;
        abVar = this.bKN.bKG;
        abVar.IN();
        com.baidu.tieba.home.t acy = bVar.acy();
        if (acy != null && acy.getErrorNumber() == 0) {
            abVar2 = this.bKN.bKG;
            abVar2.d(bVar);
            return;
        }
        this.bKN.showToast(acy.getUserMsg(), false);
        this.bKN.finish();
    }

    @Override // com.baidu.tieba.signall.g
    public void fw(String str) {
        ab abVar;
        abVar = this.bKN.bKG;
        abVar.IN();
        this.bKN.showToast(str, false);
        this.bKN.finish();
    }
}
