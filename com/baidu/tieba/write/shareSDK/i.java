package com.baidu.tieba.write.shareSDK;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.write.view.i {
    final /* synthetic */ WriteShareActivity cAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteShareActivity writeShareActivity) {
        this.cAt = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.i
    public void a(com.baidu.tieba.write.view.f fVar) {
        boolean z;
        fVar.dismiss();
        z = this.cAt.cAh;
        if (!z) {
            this.cAt.setResult(0);
        }
        com.baidu.tbadk.core.c.b.a(this.cAt.getPageContext().getPageActivity(), 200, false);
        this.cAt.finish();
    }
}
