package com.baidu.tieba.write.shareSDK;

import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class h implements e.b {
    final /* synthetic */ WriteShareActivity fac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.fac = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        boolean z;
        eVar.dismiss();
        z = this.fac.eZP;
        if (!z) {
            this.fac.setResult(0);
        }
        com.baidu.tbadk.core.e.b.b(this.fac.getPageContext().getPageActivity(), 200, false);
        this.fac.finish();
    }
}
