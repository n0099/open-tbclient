package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bRF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SquareSearchActivity squareSearchActivity) {
        this.bRF = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (this.bRF.bQZ != null && this.bRF.bQZ.trim().length() >= 1) {
            if (this.bRF.mMode != 0) {
                if (this.bRF.mMode == 3) {
                    com.baidu.adp.lib.util.k.c(this.bRF.getPageContext().getPageActivity(), this.bRF.bQH);
                    if (!TextUtils.isEmpty(this.bRF.bQZ) && this.bRF.bQZ.trim().length() != 0) {
                        this.bRF.bQZ = this.bRF.bQZ.trim();
                        this.bRF.ge(this.bRF.bQZ);
                        return;
                    }
                    return;
                }
                this.bRF.E(1, this.bRF.bQZ);
                return;
            }
            z = this.bRF.asX;
            if (z) {
                this.bRF.aaa();
                return;
            }
            return;
        }
        this.bRF.showToast(this.bRF.getResources().getString(i.h.write_keyword));
    }
}
