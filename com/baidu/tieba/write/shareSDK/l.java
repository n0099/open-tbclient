package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class l implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity cAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.cAu = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        q qVar;
        boolean z;
        q qVar2;
        q qVar3;
        q qVar4;
        if (i == 4) {
            qVar = this.cAu.cAf;
            if (qVar != null) {
                qVar2 = this.cAu.cAf;
                if (qVar2.asK() != null) {
                    qVar3 = this.cAu.cAf;
                    if (qVar3.asK().isShowing()) {
                        qVar4 = this.cAu.cAf;
                        com.baidu.adp.lib.g.k.a(qVar4.asK(), this.cAu.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.cAu.asy();
            z = this.cAu.cAi;
            if (z) {
                this.cAu.setResult(-1);
            } else {
                this.cAu.setResult(0);
            }
            com.baidu.tbadk.core.c.b.a(this.cAu.getPageContext().getPageActivity(), 200, false);
            this.cAu.finish();
            return true;
        }
        return false;
    }
}
