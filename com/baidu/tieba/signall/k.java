package com.baidu.tieba.signall;

import com.baidu.tieba.signall.f;
/* loaded from: classes.dex */
class k implements f.a {
    final /* synthetic */ SignAllForumActivity cQx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SignAllForumActivity signAllForumActivity) {
        this.cQx = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.f.a
    public void a(c cVar) {
        z zVar;
        z zVar2;
        zVar = this.cQx.cQp;
        zVar.IU();
        a atr = cVar.atr();
        if (atr != null && atr.getErrorNumber() == 0) {
            zVar2 = this.cQx.cQp;
            zVar2.d(cVar);
            return;
        }
        this.cQx.showToast(atr.getUserMsg(), false);
        this.cQx.finish();
    }

    @Override // com.baidu.tieba.signall.f.a
    public void hQ(String str) {
        z zVar;
        zVar = this.cQx.cQp;
        zVar.IU();
        this.cQx.showToast(str, false);
        this.cQx.finish();
    }
}
