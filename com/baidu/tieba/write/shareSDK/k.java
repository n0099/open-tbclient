package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity fac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.fac = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        o oVar;
        boolean z;
        o oVar2;
        o oVar3;
        o oVar4;
        if (i == 4) {
            oVar = this.fac.eZM;
            if (oVar != null) {
                oVar2 = this.fac.eZM;
                if (oVar2.bct() != null) {
                    oVar3 = this.fac.eZM;
                    if (oVar3.bct().isShowing()) {
                        oVar4 = this.fac.eZM;
                        com.baidu.adp.lib.h.j.a(oVar4.bct(), this.fac.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.fac.bci();
            z = this.fac.eZP;
            if (z) {
                this.fac.setResult(-1);
            } else {
                this.fac.setResult(0);
            }
            com.baidu.tbadk.core.e.b.b(this.fac.getPageContext().getPageActivity(), 200, false);
            this.fac.finish();
            return true;
        }
        return false;
    }
}
