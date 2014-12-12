package com.baidu.tieba.shareSDK;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity bNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.bNV = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.bNV.acy();
        z = this.bNV.bNK;
        MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.valueOf(z)));
        com.baidu.tbadk.core.b.b.a(this.bNV.getPageContext().getPageActivity(), Constants.MEDIA_INFO, false);
        this.bNV.finish();
    }
}
