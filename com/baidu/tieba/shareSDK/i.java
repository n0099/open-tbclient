package com.baidu.tieba.shareSDK;

import com.baidu.adp.framework.MessageManager;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ WriteShareActivity bNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteShareActivity writeShareActivity) {
        this.bNV = writeShareActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void onClick(com.baidu.tbadk.core.dialog.e eVar) {
        boolean z;
        eVar.dismiss();
        z = this.bNV.bNK;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
        }
        com.baidu.tbadk.core.b.b.a(this.bNV.getPageContext().getPageActivity(), Constants.MEDIA_INFO, false);
        this.bNV.finish();
    }
}
