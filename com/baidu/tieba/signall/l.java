package com.baidu.tieba.signall;

import com.baidu.tieba.signall.f;
/* loaded from: classes.dex */
class l implements f.a {
    final /* synthetic */ SignAllForumActivity ejs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.ejs = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.f.a
    public void a(c cVar) {
        af afVar;
        af afVar2;
        f fVar;
        afVar = this.ejs.ejk;
        afVar.Np();
        a aPS = cVar.aPS();
        if (aPS != null && aPS.getErrorNumber() == 0) {
            afVar2 = this.ejs.ejk;
            fVar = this.ejs.ejl;
            afVar2.a(cVar, fVar.aQl());
            return;
        }
        this.ejs.showToast(aPS.getUserMsg(), false);
        this.ejs.finish();
    }

    @Override // com.baidu.tieba.signall.f.a
    public void jm(String str) {
        af afVar;
        afVar = this.ejs.ejk;
        afVar.Np();
        this.ejs.showToast(str, false);
        this.ejs.finish();
    }
}
