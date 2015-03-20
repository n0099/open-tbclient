package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class l implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity cvN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.cvN = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        q qVar;
        boolean z;
        q qVar2;
        q qVar3;
        q qVar4;
        if (i == 4) {
            qVar = this.cvN.cvy;
            if (qVar != null) {
                qVar2 = this.cvN.cvy;
                if (qVar2.aqE() != null) {
                    qVar3 = this.cvN.cvy;
                    if (qVar3.aqE().isShowing()) {
                        qVar4 = this.cvN.cvy;
                        com.baidu.adp.lib.g.k.a(qVar4.aqE(), this.cvN.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.cvN.aqs();
            z = this.cvN.cvB;
            if (z) {
                this.cvN.setResult(-1);
            } else {
                this.cvN.setResult(0);
            }
            com.baidu.tbadk.core.c.b.a(this.cvN.getPageContext().getPageActivity(), 200, false);
            this.cvN.finish();
            return true;
        }
        return false;
    }
}
