package com.baidu.tieba.write.shareSDK;

import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class h implements e.b {
    final /* synthetic */ WriteShareActivity cSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.cSj = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        boolean z;
        eVar.dismiss();
        z = this.cSj.cRW;
        if (!z) {
            this.cSj.setResult(0);
        }
        com.baidu.tbadk.core.c.b.a(this.cSj.getPageContext().getPageActivity(), 200, false);
        this.cSj.finish();
    }
}
