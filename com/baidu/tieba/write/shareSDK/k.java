package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity dog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.dog = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        o oVar;
        boolean z;
        o oVar2;
        o oVar3;
        o oVar4;
        if (i == 4) {
            oVar = this.dog.dnQ;
            if (oVar != null) {
                oVar2 = this.dog.dnQ;
                if (oVar2.aCY() != null) {
                    oVar3 = this.dog.dnQ;
                    if (oVar3.aCY().isShowing()) {
                        oVar4 = this.dog.dnQ;
                        com.baidu.adp.lib.g.j.a(oVar4.aCY(), this.dog.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.dog.aCN();
            z = this.dog.dnT;
            if (z) {
                this.dog.setResult(-1);
            } else {
                this.dog.setResult(0);
            }
            com.baidu.tbadk.core.c.b.b(this.dog.getPageContext().getPageActivity(), 200, false);
            this.dog.finish();
            return true;
        }
        return false;
    }
}
