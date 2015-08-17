package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity cSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.cSj = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        o oVar;
        boolean z;
        o oVar2;
        o oVar3;
        o oVar4;
        if (i == 4) {
            oVar = this.cSj.cRT;
            if (oVar != null) {
                oVar2 = this.cSj.cRT;
                if (oVar2.auA() != null) {
                    oVar3 = this.cSj.cRT;
                    if (oVar3.auA().isShowing()) {
                        oVar4 = this.cSj.cRT;
                        com.baidu.adp.lib.g.j.a(oVar4.auA(), this.cSj.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.cSj.auo();
            z = this.cSj.cRW;
            if (z) {
                this.cSj.setResult(-1);
            } else {
                this.cSj.setResult(0);
            }
            com.baidu.tbadk.core.c.b.a(this.cSj.getPageContext().getPageActivity(), 200, false);
            this.cSj.finish();
            return true;
        }
        return false;
    }
}
