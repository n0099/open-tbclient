package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cLU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SquareSearchActivity squareSearchActivity) {
        this.cLU = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean aov;
        boolean z;
        if (this.cLU.cLn == null || this.cLU.cLn.trim().length() < 1) {
            com.baidu.adp.lib.util.k.c(this.cLU.getPageContext().getPageActivity(), this.cLU.cKS);
            aov = this.cLU.aov();
            if (!aov) {
                this.cLU.showToast(this.cLU.getResources().getString(t.j.write_keyword));
            }
        } else if (this.cLU.mMode != 0) {
            if (this.cLU.mMode == 3) {
                com.baidu.adp.lib.util.k.c(this.cLU.getPageContext().getPageActivity(), this.cLU.cKS);
                if (!TextUtils.isEmpty(this.cLU.cLn) && this.cLU.cLn.trim().length() != 0) {
                    this.cLU.cLn = this.cLU.cLn.trim();
                    this.cLU.gM(this.cLU.cLn);
                    return;
                }
                return;
            }
            this.cLU.D(1, this.cLU.cLn);
        } else {
            z = this.cLU.auT;
            if (z) {
                this.cLU.aoE();
            }
        }
    }
}
