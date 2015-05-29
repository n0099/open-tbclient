package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class l implements h {
    final /* synthetic */ SignAllForumActivity cir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.cir = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.h
    public void a(c cVar) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.cir.cij;
        aeVar.Ix();
        a akm = cVar.akm();
        if (akm != null && akm.getErrorNumber() == 0) {
            aeVar2 = this.cir.cij;
            aeVar2.d(cVar);
            return;
        }
        this.cir.showToast(akm.getUserMsg(), false);
        this.cir.finish();
    }

    @Override // com.baidu.tieba.signall.h
    public void he(String str) {
        ae aeVar;
        aeVar = this.cir.cij;
        aeVar.Ix();
        this.cir.showToast(str, false);
        this.cir.finish();
    }
}
