package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class l implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity cwd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.cwd = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        q qVar;
        boolean z;
        q qVar2;
        q qVar3;
        q qVar4;
        if (i == 4) {
            qVar = this.cwd.cvO;
            if (qVar != null) {
                qVar2 = this.cwd.cvO;
                if (qVar2.aqT() != null) {
                    qVar3 = this.cwd.cvO;
                    if (qVar3.aqT().isShowing()) {
                        qVar4 = this.cwd.cvO;
                        com.baidu.adp.lib.g.k.a(qVar4.aqT(), this.cwd.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.cwd.aqH();
            z = this.cwd.cvR;
            if (z) {
                this.cwd.setResult(-1);
            } else {
                this.cwd.setResult(0);
            }
            com.baidu.tbadk.core.c.b.a(this.cwd.getPageContext().getPageActivity(), 200, false);
            this.cwd.finish();
            return true;
        }
        return false;
    }
}
