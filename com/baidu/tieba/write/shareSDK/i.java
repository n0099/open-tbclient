package com.baidu.tieba.write.shareSDK;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.write.view.i {
    final /* synthetic */ WriteShareActivity cvN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteShareActivity writeShareActivity) {
        this.cvN = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.i
    public void onClick(com.baidu.tieba.write.view.f fVar) {
        boolean z;
        fVar.dismiss();
        z = this.cvN.cvB;
        if (!z) {
            this.cvN.setResult(0);
        }
        com.baidu.tbadk.core.c.b.a(this.cvN.getPageContext().getPageActivity(), 200, false);
        this.cvN.finish();
    }
}
