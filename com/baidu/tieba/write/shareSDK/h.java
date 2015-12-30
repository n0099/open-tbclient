package com.baidu.tieba.write.shareSDK;

import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class h implements e.b {
    final /* synthetic */ WriteShareActivity dUL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.dUL = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        boolean z;
        eVar.dismiss();
        z = this.dUL.dUy;
        if (!z) {
            this.dUL.setResult(0);
        }
        com.baidu.tbadk.core.c.b.b(this.dUL.getPageContext().getPageActivity(), 200, false);
        this.dUL.finish();
    }
}
