package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SquareSearchActivity squareSearchActivity) {
        this.bQZ = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (this.bQZ.bQt != null && this.bQZ.bQt.trim().length() >= 1) {
            if (this.bQZ.mMode != 0) {
                if (this.bQZ.mMode == 3) {
                    com.baidu.adp.lib.util.k.c(this.bQZ.getPageContext().getPageActivity(), this.bQZ.bQb);
                    if (!TextUtils.isEmpty(this.bQZ.bQt) && this.bQZ.bQt.trim().length() != 0) {
                        this.bQZ.bQt = this.bQZ.bQt.trim();
                        this.bQZ.fX(this.bQZ.bQt);
                        return;
                    }
                    return;
                }
                this.bQZ.G(1, this.bQZ.bQt);
                return;
            }
            z = this.bQZ.arn;
            if (z) {
                this.bQZ.ZV();
                return;
            }
            return;
        }
        this.bQZ.showToast(this.bQZ.getResources().getString(i.C0057i.write_keyword));
    }
}
