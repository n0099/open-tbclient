package com.baidu.tieba.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity bPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.bPF = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        q qVar;
        boolean z;
        q qVar2;
        q qVar3;
        q qVar4;
        if (i == 4) {
            qVar = this.bPF.bPr;
            if (qVar != null) {
                qVar2 = this.bPF.bPr;
                if (qVar2.ado() != null) {
                    qVar3 = this.bPF.bPr;
                    if (qVar3.ado().isShowing()) {
                        qVar4 = this.bPF.bPr;
                        com.baidu.adp.lib.g.k.a(qVar4.ado(), this.bPF.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.bPF.adc();
            z = this.bPF.bPu;
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.valueOf(z)));
            com.baidu.tbadk.core.b.b.a(this.bPF.getPageContext().getPageActivity(), 200, false);
            this.bPF.finish();
            return true;
        }
        return false;
    }
}
