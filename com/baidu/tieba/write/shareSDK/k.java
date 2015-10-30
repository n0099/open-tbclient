package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity dmy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.dmy = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        o oVar;
        boolean z;
        o oVar2;
        o oVar3;
        o oVar4;
        if (i == 4) {
            oVar = this.dmy.dmi;
            if (oVar != null) {
                oVar2 = this.dmy.dmi;
                if (oVar2.aCi() != null) {
                    oVar3 = this.dmy.dmi;
                    if (oVar3.aCi().isShowing()) {
                        oVar4 = this.dmy.dmi;
                        com.baidu.adp.lib.g.j.a(oVar4.aCi(), this.dmy.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.dmy.aBX();
            z = this.dmy.dml;
            if (z) {
                this.dmy.setResult(-1);
            } else {
                this.dmy.setResult(0);
            }
            com.baidu.tbadk.core.c.b.b(this.dmy.getPageContext().getPageActivity(), 200, false);
            this.dmy.finish();
            return true;
        }
        return false;
    }
}
