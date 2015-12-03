package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareSearchActivity squareSearchActivity) {
        this.cmr = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean afb;
        boolean z;
        if (this.cmr.clJ == null || this.cmr.clJ.trim().length() < 1) {
            com.baidu.adp.lib.util.k.c(this.cmr.getPageContext().getPageActivity(), this.cmr.cln);
            afb = this.cmr.afb();
            if (!afb) {
                this.cmr.showToast(this.cmr.getResources().getString(n.i.write_keyword));
            }
        } else if (this.cmr.mMode != 0) {
            if (this.cmr.mMode == 3) {
                com.baidu.adp.lib.util.k.c(this.cmr.getPageContext().getPageActivity(), this.cmr.cln);
                if (!TextUtils.isEmpty(this.cmr.clJ) && this.cmr.clJ.trim().length() != 0) {
                    this.cmr.clJ = this.cmr.clJ.trim();
                    this.cmr.gw(this.cmr.clJ);
                    return;
                }
                return;
            }
            this.cmr.I(1, this.cmr.clJ);
        } else {
            z = this.cmr.arX;
            if (z) {
                this.cmr.afl();
            }
        }
    }
}
