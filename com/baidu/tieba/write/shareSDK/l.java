package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class l implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity cAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.cAt = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        q qVar;
        boolean z;
        q qVar2;
        q qVar3;
        q qVar4;
        if (i == 4) {
            qVar = this.cAt.cAe;
            if (qVar != null) {
                qVar2 = this.cAt.cAe;
                if (qVar2.asJ() != null) {
                    qVar3 = this.cAt.cAe;
                    if (qVar3.asJ().isShowing()) {
                        qVar4 = this.cAt.cAe;
                        com.baidu.adp.lib.g.k.a(qVar4.asJ(), this.cAt.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.cAt.asx();
            z = this.cAt.cAh;
            if (z) {
                this.cAt.setResult(-1);
            } else {
                this.cAt.setResult(0);
            }
            com.baidu.tbadk.core.c.b.a(this.cAt.getPageContext().getPageActivity(), 200, false);
            this.cAt.finish();
            return true;
        }
        return false;
    }
}
