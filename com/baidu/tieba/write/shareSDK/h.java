package com.baidu.tieba.write.shareSDK;

import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class h implements e.b {
    final /* synthetic */ WriteShareActivity daW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.daW = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        boolean z;
        eVar.dismiss();
        z = this.daW.daJ;
        if (!z) {
            this.daW.setResult(0);
        }
        com.baidu.tbadk.core.c.b.a(this.daW.getPageContext().getPageActivity(), 200, false);
        this.daW.finish();
    }
}
