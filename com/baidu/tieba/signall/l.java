package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class l implements h {
    final /* synthetic */ SignAllForumActivity cem;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.cem = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.h
    public void a(c cVar) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.cem.cee;
        aeVar.Hx();
        a aiC = cVar.aiC();
        if (aiC != null && aiC.getErrorNumber() == 0) {
            aeVar2 = this.cem.cee;
            aeVar2.d(cVar);
            return;
        }
        this.cem.showToast(aiC.getUserMsg(), false);
        this.cem.finish();
    }

    @Override // com.baidu.tieba.signall.h
    public void gB(String str) {
        ae aeVar;
        aeVar = this.cem.cee;
        aeVar.Hx();
        this.cem.showToast(str, false);
        this.cem.finish();
    }
}
