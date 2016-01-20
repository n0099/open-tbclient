package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareSearchActivity squareSearchActivity) {
        this.cqu = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean agk;
        boolean z;
        if (this.cqu.cpN == null || this.cqu.cpN.trim().length() < 1) {
            com.baidu.adp.lib.util.k.c(this.cqu.getPageContext().getPageActivity(), this.cqu.cpr);
            agk = this.cqu.agk();
            if (!agk) {
                this.cqu.showToast(this.cqu.getResources().getString(n.j.write_keyword));
            }
        } else if (this.cqu.mMode != 0) {
            if (this.cqu.mMode == 3) {
                com.baidu.adp.lib.util.k.c(this.cqu.getPageContext().getPageActivity(), this.cqu.cpr);
                if (!TextUtils.isEmpty(this.cqu.cpN) && this.cqu.cpN.trim().length() != 0) {
                    this.cqu.cpN = this.cqu.cpN.trim();
                    this.cqu.gB(this.cqu.cpN);
                    return;
                }
                return;
            }
            this.cqu.I(1, this.cqu.cpN);
        } else {
            z = this.cqu.atB;
            if (z) {
                this.cqu.agu();
            }
        }
    }
}
