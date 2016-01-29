package com.baidu.tieba.signall;

import com.baidu.tieba.signall.f;
/* loaded from: classes.dex */
class l implements f.a {
    final /* synthetic */ SignAllForumActivity dNI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.dNI = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.f.a
    public void a(c cVar) {
        af afVar;
        af afVar2;
        f fVar;
        afVar = this.dNI.dNA;
        afVar.MB();
        a aIJ = cVar.aIJ();
        if (aIJ != null && aIJ.getErrorNumber() == 0) {
            afVar2 = this.dNI.dNA;
            fVar = this.dNI.dNB;
            afVar2.a(cVar, fVar.aJc());
            return;
        }
        this.dNI.showToast(aIJ.getUserMsg(), false);
        this.dNI.finish();
    }

    @Override // com.baidu.tieba.signall.f.a
    public void iB(String str) {
        af afVar;
        afVar = this.dNI.dNA;
        afVar.MB();
        this.dNI.showToast(str, false);
        this.dNI.finish();
    }
}
