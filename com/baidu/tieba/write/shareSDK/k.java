package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity eJm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.eJm = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        o oVar;
        boolean z;
        o oVar2;
        o oVar3;
        o oVar4;
        if (i == 4) {
            oVar = this.eJm.eIW;
            if (oVar != null) {
                oVar2 = this.eJm.eIW;
                if (oVar2.baa() != null) {
                    oVar3 = this.eJm.eIW;
                    if (oVar3.baa().isShowing()) {
                        oVar4 = this.eJm.eIW;
                        com.baidu.adp.lib.h.j.a(oVar4.baa(), this.eJm.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.eJm.aZP();
            z = this.eJm.eIZ;
            if (z) {
                this.eJm.setResult(-1);
            } else {
                this.eJm.setResult(0);
            }
            com.baidu.tbadk.core.d.b.b(this.eJm.getPageContext().getPageActivity(), 200, false);
            this.eJm.finish();
            return true;
        }
        return false;
    }
}
