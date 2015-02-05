package com.baidu.tieba.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity bPE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.bPE = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        q qVar;
        boolean z;
        q qVar2;
        q qVar3;
        q qVar4;
        if (i == 4) {
            qVar = this.bPE.bPq;
            if (qVar != null) {
                qVar2 = this.bPE.bPq;
                if (qVar2.adj() != null) {
                    qVar3 = this.bPE.bPq;
                    if (qVar3.adj().isShowing()) {
                        qVar4 = this.bPE.bPq;
                        com.baidu.adp.lib.g.k.a(qVar4.adj(), this.bPE.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.bPE.acX();
            z = this.bPE.bPt;
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.valueOf(z)));
            com.baidu.tbadk.core.b.b.a(this.bPE.getPageContext().getPageActivity(), 200, false);
            this.bPE.finish();
            return true;
        }
        return false;
    }
}
