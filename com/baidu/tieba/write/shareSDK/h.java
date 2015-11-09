package com.baidu.tieba.write.shareSDK;

import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class h implements e.b {
    final /* synthetic */ WriteShareActivity dog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.dog = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        boolean z;
        eVar.dismiss();
        z = this.dog.dnT;
        if (!z) {
            this.dog.setResult(0);
        }
        com.baidu.tbadk.core.c.b.b(this.dog.getPageContext().getPageActivity(), 200, false);
        this.dog.finish();
    }
}
