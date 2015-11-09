package com.baidu.tieba.signall;

import com.baidu.tieba.signall.f;
/* loaded from: classes.dex */
class k implements f.a {
    final /* synthetic */ SignAllForumActivity cRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SignAllForumActivity signAllForumActivity) {
        this.cRT = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.f.a
    public void a(c cVar) {
        z zVar;
        z zVar2;
        zVar = this.cRT.cRL;
        zVar.Jg();
        a atT = cVar.atT();
        if (atT != null && atT.getErrorNumber() == 0) {
            zVar2 = this.cRT.cRL;
            zVar2.d(cVar);
            return;
        }
        this.cRT.showToast(atT.getUserMsg(), false);
        this.cRT.finish();
    }

    @Override // com.baidu.tieba.signall.f.a
    public void hS(String str) {
        z zVar;
        zVar = this.cRT.cRL;
        zVar.Jg();
        this.cRT.showToast(str, false);
        this.cRT.finish();
    }
}
