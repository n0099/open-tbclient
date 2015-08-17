package com.baidu.tieba.signall;

import com.baidu.tieba.signall.f;
/* loaded from: classes.dex */
class k implements f.a {
    final /* synthetic */ SignAllForumActivity cAF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SignAllForumActivity signAllForumActivity) {
        this.cAF = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.f.a
    public void a(c cVar) {
        z zVar;
        z zVar2;
        zVar = this.cAF.cAx;
        zVar.Jl();
        a amO = cVar.amO();
        if (amO != null && amO.getErrorNumber() == 0) {
            zVar2 = this.cAF.cAx;
            zVar2.d(cVar);
            return;
        }
        this.cAF.showToast(amO.getUserMsg(), false);
        this.cAF.finish();
    }

    @Override // com.baidu.tieba.signall.f.a
    public void hD(String str) {
        z zVar;
        zVar = this.cAF.cAx;
        zVar.Jl();
        this.cAF.showToast(str, false);
        this.cAF.finish();
    }
}
