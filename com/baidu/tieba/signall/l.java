package com.baidu.tieba.signall;

import com.baidu.tieba.signall.f;
/* loaded from: classes.dex */
class l implements f.a {
    final /* synthetic */ SignAllForumActivity dxE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.dxE = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.f.a
    public void a(c cVar) {
        ae aeVar;
        ae aeVar2;
        f fVar;
        aeVar = this.dxE.dxw;
        aeVar.KK();
        a aBC = cVar.aBC();
        if (aBC != null && aBC.getErrorNumber() == 0) {
            aeVar2 = this.dxE.dxw;
            fVar = this.dxE.dxx;
            aeVar2.a(cVar, fVar.aBV());
            return;
        }
        this.dxE.showToast(aBC.getUserMsg(), false);
        this.dxE.finish();
    }

    @Override // com.baidu.tieba.signall.f.a
    public void iz(String str) {
        ae aeVar;
        aeVar = this.dxE.dxw;
        aeVar.KK();
        this.dxE.showToast(str, false);
        this.dxE.finish();
    }
}
