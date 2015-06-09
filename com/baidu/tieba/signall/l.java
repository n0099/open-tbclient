package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class l implements h {
    final /* synthetic */ SignAllForumActivity cis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.cis = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.h
    public void a(c cVar) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.cis.cik;
        aeVar.Iy();
        a akn = cVar.akn();
        if (akn != null && akn.getErrorNumber() == 0) {
            aeVar2 = this.cis.cik;
            aeVar2.d(cVar);
            return;
        }
        this.cis.showToast(akn.getUserMsg(), false);
        this.cis.finish();
    }

    @Override // com.baidu.tieba.signall.h
    public void he(String str) {
        ae aeVar;
        aeVar = this.cis.cik;
        aeVar.Iy();
        this.cis.showToast(str, false);
        this.cis.finish();
    }
}
