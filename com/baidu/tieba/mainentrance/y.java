package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareSearchActivity squareSearchActivity) {
        this.bWd = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean abv;
        boolean z;
        if (this.bWd.bVw != null && this.bWd.bVw.trim().length() >= 1) {
            if (this.bWd.mMode != 0) {
                if (this.bWd.mMode == 3) {
                    com.baidu.adp.lib.util.k.c(this.bWd.getPageContext().getPageActivity(), this.bWd.bVb);
                    if (!TextUtils.isEmpty(this.bWd.bVw) && this.bWd.bVw.trim().length() != 0) {
                        this.bWd.bVw = this.bWd.bVw.trim();
                        this.bWd.gj(this.bWd.bVw);
                        return;
                    }
                    return;
                }
                this.bWd.H(1, this.bWd.bVw);
                return;
            }
            z = this.bWd.aqa;
            if (z) {
                this.bWd.abF();
                return;
            }
            return;
        }
        com.baidu.adp.lib.util.k.c(this.bWd.getPageContext().getPageActivity(), this.bWd.bVb);
        abv = this.bWd.abv();
        if (!abv) {
            this.bWd.showToast(this.bWd.getResources().getString(i.h.write_keyword));
        }
    }
}
