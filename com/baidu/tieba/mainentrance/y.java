package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareSearchActivity squareSearchActivity) {
        this.bVr = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean abe;
        boolean z;
        if (this.bVr.bUK != null && this.bVr.bUK.trim().length() >= 1) {
            if (this.bVr.mMode != 0) {
                if (this.bVr.mMode == 3) {
                    com.baidu.adp.lib.util.k.c(this.bVr.getPageContext().getPageActivity(), this.bVr.bUp);
                    if (!TextUtils.isEmpty(this.bVr.bUK) && this.bVr.bUK.trim().length() != 0) {
                        this.bVr.bUK = this.bVr.bUK.trim();
                        this.bVr.gh(this.bVr.bUK);
                        return;
                    }
                    return;
                }
                this.bVr.G(1, this.bVr.bUK);
                return;
            }
            z = this.bVr.aru;
            if (z) {
                this.bVr.abo();
                return;
            }
            return;
        }
        com.baidu.adp.lib.util.k.c(this.bVr.getPageContext().getPageActivity(), this.bVr.bUp);
        abe = this.bVr.abe();
        if (!abe) {
            this.bVr.showToast(this.bVr.getResources().getString(i.h.write_keyword));
        }
    }
}
