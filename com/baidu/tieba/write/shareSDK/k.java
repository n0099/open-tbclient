package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity epq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.epq = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        o oVar;
        boolean z;
        o oVar2;
        o oVar3;
        o oVar4;
        if (i == 4) {
            oVar = this.epq.epa;
            if (oVar != null) {
                oVar2 = this.epq.epa;
                if (oVar2.aTA() != null) {
                    oVar3 = this.epq.epa;
                    if (oVar3.aTA().isShowing()) {
                        oVar4 = this.epq.epa;
                        com.baidu.adp.lib.h.j.a(oVar4.aTA(), this.epq.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.epq.aTp();
            z = this.epq.epd;
            if (z) {
                this.epq.setResult(-1);
            } else {
                this.epq.setResult(0);
            }
            com.baidu.tbadk.core.c.b.b(this.epq.getPageContext().getPageActivity(), 200, false);
            this.epq.finish();
            return true;
        }
        return false;
    }
}
