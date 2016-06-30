package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity fFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.fFg = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        o oVar;
        boolean z;
        o oVar2;
        o oVar3;
        o oVar4;
        if (i == 4) {
            oVar = this.fFg.fEQ;
            if (oVar != null) {
                oVar2 = this.fFg.fEQ;
                if (oVar2.bkO() != null) {
                    oVar3 = this.fFg.fEQ;
                    if (oVar3.bkO().isShowing()) {
                        oVar4 = this.fFg.fEQ;
                        com.baidu.adp.lib.h.j.a(oVar4.bkO(), this.fFg.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.fFg.bkD();
            z = this.fFg.fET;
            if (z) {
                this.fFg.setResult(-1);
            } else {
                this.fFg.setResult(0);
            }
            com.baidu.tbadk.core.d.b.c(this.fFg.getPageContext().getPageActivity(), 200, false);
            this.fFg.finish();
            return true;
        }
        return false;
    }
}
