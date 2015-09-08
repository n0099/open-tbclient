package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity daW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.daW = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        o oVar;
        boolean z;
        o oVar2;
        o oVar3;
        o oVar4;
        if (i == 4) {
            oVar = this.daW.daG;
            if (oVar != null) {
                oVar2 = this.daW.daG;
                if (oVar2.ayT() != null) {
                    oVar3 = this.daW.daG;
                    if (oVar3.ayT().isShowing()) {
                        oVar4 = this.daW.daG;
                        com.baidu.adp.lib.g.j.a(oVar4.ayT(), this.daW.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.daW.ayI();
            z = this.daW.daJ;
            if (z) {
                this.daW.setResult(-1);
            } else {
                this.daW.setResult(0);
            }
            com.baidu.tbadk.core.c.b.a(this.daW.getPageContext().getPageActivity(), 200, false);
            this.daW.finish();
            return true;
        }
        return false;
    }
}
