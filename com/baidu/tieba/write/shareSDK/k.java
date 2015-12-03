package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
class k implements DialogInterface.OnKeyListener {
    final /* synthetic */ WriteShareActivity dNm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.dNm = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        o oVar;
        boolean z;
        o oVar2;
        o oVar3;
        o oVar4;
        if (i == 4) {
            oVar = this.dNm.dMW;
            if (oVar != null) {
                oVar2 = this.dNm.dMW;
                if (oVar2.aIv() != null) {
                    oVar3 = this.dNm.dMW;
                    if (oVar3.aIv().isShowing()) {
                        oVar4 = this.dNm.dMW;
                        com.baidu.adp.lib.h.j.a(oVar4.aIv(), this.dNm.getPageContext().getPageActivity());
                        return true;
                    }
                }
            }
            this.dNm.aIk();
            z = this.dNm.dMZ;
            if (z) {
                this.dNm.setResult(-1);
            } else {
                this.dNm.setResult(0);
            }
            com.baidu.tbadk.core.c.b.b(this.dNm.getPageContext().getPageActivity(), 200, false);
            this.dNm.finish();
            return true;
        }
        return false;
    }
}
