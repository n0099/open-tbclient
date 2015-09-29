package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity dlY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.dlY = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        o oVar;
        boolean z;
        o oVar2;
        o oVar3;
        o oVar4;
        if (i == 4) {
            oVar = this.dlY.dlI;
            if (oVar != null) {
                oVar2 = this.dlY.dlI;
                if (oVar2.aCc() != null) {
                    oVar3 = this.dlY.dlI;
                    if (oVar3.aCc().isShowing()) {
                        oVar4 = this.dlY.dlI;
                        com.baidu.adp.lib.g.j.a(oVar4.aCc(), this.dlY.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.dlY.aBR();
            z = this.dlY.dlL;
            if (z) {
                this.dlY.setResult(-1);
            } else {
                this.dlY.setResult(0);
            }
            com.baidu.tbadk.core.c.b.b(this.dlY.getPageContext().getPageActivity(), 200, false);
            this.dlY.finish();
            return true;
        }
        return false;
    }
}
