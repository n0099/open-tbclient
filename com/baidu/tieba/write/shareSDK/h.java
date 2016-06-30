package com.baidu.tieba.write.shareSDK;

import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class h implements e.b {
    final /* synthetic */ WriteShareActivity fFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.fFg = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        boolean z;
        eVar.dismiss();
        z = this.fFg.fET;
        if (!z) {
            this.fFg.setResult(0);
        }
        com.baidu.tbadk.core.d.b.c(this.fFg.getPageContext().getPageActivity(), 200, false);
        this.fFg.finish();
    }
}
