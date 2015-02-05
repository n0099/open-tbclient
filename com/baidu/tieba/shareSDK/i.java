package com.baidu.tieba.shareSDK;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ WriteShareActivity bPE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteShareActivity writeShareActivity) {
        this.bPE = writeShareActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void onClick(com.baidu.tbadk.core.dialog.e eVar) {
        boolean z;
        eVar.dismiss();
        z = this.bPE.bPt;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
        }
        com.baidu.tbadk.core.b.b.a(this.bPE.getPageContext().getPageActivity(), 200, false);
        this.bPE.finish();
    }
}
