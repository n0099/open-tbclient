package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity dUL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.dUL = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        o oVar;
        boolean z;
        o oVar2;
        o oVar3;
        o oVar4;
        if (i == 4) {
            oVar = this.dUL.dUv;
            if (oVar != null) {
                oVar2 = this.dUL.dUv;
                if (oVar2.aKQ() != null) {
                    oVar3 = this.dUL.dUv;
                    if (oVar3.aKQ().isShowing()) {
                        oVar4 = this.dUL.dUv;
                        com.baidu.adp.lib.h.j.a(oVar4.aKQ(), this.dUL.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.dUL.aKF();
            z = this.dUL.dUy;
            if (z) {
                this.dUL.setResult(-1);
            } else {
                this.dUL.setResult(0);
            }
            com.baidu.tbadk.core.c.b.b(this.dUL.getPageContext().getPageActivity(), 200, false);
            this.dUL.finish();
            return true;
        }
        return false;
    }
}
