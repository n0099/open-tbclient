package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity fad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.fad = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        o oVar;
        boolean z;
        o oVar2;
        o oVar3;
        o oVar4;
        if (i == 4) {
            oVar = this.fad.eZN;
            if (oVar != null) {
                oVar2 = this.fad.eZN;
                if (oVar2.bcm() != null) {
                    oVar3 = this.fad.eZN;
                    if (oVar3.bcm().isShowing()) {
                        oVar4 = this.fad.eZN;
                        com.baidu.adp.lib.h.j.a(oVar4.bcm(), this.fad.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.fad.bcb();
            z = this.fad.eZQ;
            if (z) {
                this.fad.setResult(-1);
            } else {
                this.fad.setResult(0);
            }
            com.baidu.tbadk.core.e.b.b(this.fad.getPageContext().getPageActivity(), 200, false);
            this.fad.finish();
            return true;
        }
        return false;
    }
}
