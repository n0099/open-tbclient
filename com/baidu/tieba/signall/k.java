package com.baidu.tieba.signall;

import com.baidu.tieba.signall.f;
/* loaded from: classes.dex */
class k implements f.a {
    final /* synthetic */ SignAllForumActivity cPY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SignAllForumActivity signAllForumActivity) {
        this.cPY = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.f.a
    public void a(c cVar) {
        z zVar;
        z zVar2;
        zVar = this.cPY.cPQ;
        zVar.IU();
        a atl = cVar.atl();
        if (atl != null && atl.getErrorNumber() == 0) {
            zVar2 = this.cPY.cPQ;
            zVar2.d(cVar);
            return;
        }
        this.cPY.showToast(atl.getUserMsg(), false);
        this.cPY.finish();
    }

    @Override // com.baidu.tieba.signall.f.a
    public void hQ(String str) {
        z zVar;
        zVar = this.cPY.cPQ;
        zVar.IU();
        this.cPY.showToast(str, false);
        this.cPY.finish();
    }
}
