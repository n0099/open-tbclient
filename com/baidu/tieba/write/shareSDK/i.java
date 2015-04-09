package com.baidu.tieba.write.shareSDK;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.write.view.i {
    final /* synthetic */ WriteShareActivity cwd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteShareActivity writeShareActivity) {
        this.cwd = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.i
    public void onClick(com.baidu.tieba.write.view.f fVar) {
        boolean z;
        fVar.dismiss();
        z = this.cwd.cvR;
        if (!z) {
            this.cwd.setResult(0);
        }
        com.baidu.tbadk.core.c.b.a(this.cwd.getPageContext().getPageActivity(), 200, false);
        this.cwd.finish();
    }
}
