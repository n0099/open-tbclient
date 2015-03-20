package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class l implements h {
    final /* synthetic */ SignAllForumActivity cdX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.cdX = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.h
    public void a(c cVar) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.cdX.cdP;
        aeVar.Hr();
        a ain = cVar.ain();
        if (ain != null && ain.getErrorNumber() == 0) {
            aeVar2 = this.cdX.cdP;
            aeVar2.d(cVar);
            return;
        }
        this.cdX.showToast(ain.getUserMsg(), false);
        this.cdX.finish();
    }

    @Override // com.baidu.tieba.signall.h
    public void gy(String str) {
        ae aeVar;
        aeVar = this.cdX.cdP;
        aeVar.Hr();
        this.cdX.showToast(str, false);
        this.cdX.finish();
    }
}
