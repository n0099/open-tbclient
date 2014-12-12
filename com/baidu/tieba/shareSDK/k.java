package com.baidu.tieba.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity bNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.bNV = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        q qVar;
        boolean z;
        q qVar2;
        q qVar3;
        q qVar4;
        if (i == 4) {
            qVar = this.bNV.bNH;
            if (qVar != null) {
                qVar2 = this.bNV.bNH;
                if (qVar2.acK() != null) {
                    qVar3 = this.bNV.bNH;
                    if (qVar3.acK().isShowing()) {
                        qVar4 = this.bNV.bNH;
                        com.baidu.adp.lib.g.k.a(qVar4.acK(), this.bNV.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.bNV.acy();
            z = this.bNV.bNK;
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.valueOf(z)));
            com.baidu.tbadk.core.b.b.a(this.bNV.getPageContext().getPageActivity(), Constants.MEDIA_INFO, false);
            this.bNV.finish();
            return true;
        }
        return false;
    }
}
