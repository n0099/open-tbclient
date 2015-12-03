package com.baidu.tieba.write.shareSDK;

import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class h implements e.b {
    final /* synthetic */ WriteShareActivity dNm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.dNm = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        boolean z;
        eVar.dismiss();
        z = this.dNm.dMZ;
        if (!z) {
            this.dNm.setResult(0);
        }
        com.baidu.tbadk.core.c.b.b(this.dNm.getPageContext().getPageActivity(), 200, false);
        this.dNm.finish();
    }
}
