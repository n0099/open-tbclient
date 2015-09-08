package com.baidu.tieba.signall;

import com.baidu.tieba.signall.f;
/* loaded from: classes.dex */
class k implements f.a {
    final /* synthetic */ SignAllForumActivity cJd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SignAllForumActivity signAllForumActivity) {
        this.cJd = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.f.a
    public void a(c cVar) {
        z zVar;
        z zVar2;
        zVar = this.cJd.cIV;
        zVar.IZ();
        a aqX = cVar.aqX();
        if (aqX != null && aqX.getErrorNumber() == 0) {
            zVar2 = this.cJd.cIV;
            zVar2.d(cVar);
            return;
        }
        this.cJd.showToast(aqX.getUserMsg(), false);
        this.cJd.finish();
    }

    @Override // com.baidu.tieba.signall.f.a
    public void hM(String str) {
        z zVar;
        zVar = this.cJd.cIV;
        zVar.IZ();
        this.cJd.showToast(str, false);
        this.cJd.finish();
    }
}
