package com.baidu.tieba.write.shareSDK;

import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class h implements e.b {
    final /* synthetic */ WriteShareActivity eJm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.eJm = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        boolean z;
        eVar.dismiss();
        z = this.eJm.eIZ;
        if (!z) {
            this.eJm.setResult(0);
        }
        com.baidu.tbadk.core.d.b.b(this.eJm.getPageContext().getPageActivity(), 200, false);
        this.eJm.finish();
    }
}
