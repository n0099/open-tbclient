package com.baidu.tieba.write.shareSDK;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.write.view.i {
    final /* synthetic */ WriteShareActivity cAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteShareActivity writeShareActivity) {
        this.cAu = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.i
    public void a(com.baidu.tieba.write.view.f fVar) {
        boolean z;
        fVar.dismiss();
        z = this.cAu.cAi;
        if (!z) {
            this.cAu.setResult(0);
        }
        com.baidu.tbadk.core.c.b.a(this.cAu.getPageContext().getPageActivity(), 200, false);
        this.cAu.finish();
    }
}
