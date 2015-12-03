package com.baidu.tieba.signall;

import com.baidu.tieba.signall.f;
/* loaded from: classes.dex */
class k implements f.a {
    final /* synthetic */ SignAllForumActivity dqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SignAllForumActivity signAllForumActivity) {
        this.dqq = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.f.a
    public void a(c cVar) {
        z zVar;
        z zVar2;
        f fVar;
        zVar = this.dqq.dqi;
        zVar.Kr();
        a azv = cVar.azv();
        if (azv != null && azv.getErrorNumber() == 0) {
            zVar2 = this.dqq.dqi;
            fVar = this.dqq.dqj;
            zVar2.a(cVar, fVar.azO());
            return;
        }
        this.dqq.showToast(azv.getUserMsg(), false);
        this.dqq.finish();
    }

    @Override // com.baidu.tieba.signall.f.a
    public void in(String str) {
        z zVar;
        zVar = this.dqq.dqi;
        zVar.Kr();
        this.dqq.showToast(str, false);
        this.dqq.finish();
    }
}
