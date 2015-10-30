package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareSearchActivity squareSearchActivity) {
        this.bVC = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean aba;
        boolean z;
        if (this.bVC.bUV != null && this.bVC.bUV.trim().length() >= 1) {
            if (this.bVC.mMode != 0) {
                if (this.bVC.mMode == 3) {
                    com.baidu.adp.lib.util.k.c(this.bVC.getPageContext().getPageActivity(), this.bVC.bUA);
                    if (!TextUtils.isEmpty(this.bVC.bUV) && this.bVC.bUV.trim().length() != 0) {
                        this.bVC.bUV = this.bVC.bUV.trim();
                        this.bVC.gh(this.bVC.bUV);
                        return;
                    }
                    return;
                }
                this.bVC.G(1, this.bVC.bUV);
                return;
            }
            z = this.bVC.arv;
            if (z) {
                this.bVC.abk();
                return;
            }
            return;
        }
        com.baidu.adp.lib.util.k.c(this.bVC.getPageContext().getPageActivity(), this.bVC.bUA);
        aba = this.bVC.aba();
        if (!aba) {
            this.bVC.showToast(this.bVC.getResources().getString(i.h.write_keyword));
        }
    }
}
