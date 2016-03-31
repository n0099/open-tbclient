package com.baidu.tieba.signall;

import com.baidu.tieba.signall.f;
/* loaded from: classes.dex */
class l implements f.a {
    final /* synthetic */ SignAllForumActivity egh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.egh = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.f.a
    public void a(c cVar) {
        af afVar;
        af afVar2;
        f fVar;
        afVar = this.egh.efZ;
        afVar.Op();
        a aPz = cVar.aPz();
        if (aPz != null && aPz.getErrorNumber() == 0) {
            afVar2 = this.egh.efZ;
            fVar = this.egh.ega;
            afVar2.a(cVar, fVar.aPS());
            return;
        }
        this.egh.showToast(aPz.getUserMsg(), false);
        this.egh.finish();
    }

    @Override // com.baidu.tieba.signall.f.a
    public void jk(String str) {
        af afVar;
        afVar = this.egh.efZ;
        afVar.Op();
        this.egh.showToast(str, false);
        this.egh.finish();
    }
}
