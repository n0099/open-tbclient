package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SquareSearchActivity squareSearchActivity) {
        this.cwZ = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean akm;
        boolean z;
        if (this.cwZ.cws == null || this.cwZ.cws.trim().length() < 1) {
            com.baidu.adp.lib.util.k.c(this.cwZ.getPageContext().getPageActivity(), this.cwZ.cvX);
            akm = this.cwZ.akm();
            if (!akm) {
                this.cwZ.showToast(this.cwZ.getResources().getString(t.j.write_keyword));
            }
        } else if (this.cwZ.mMode != 0) {
            if (this.cwZ.mMode == 3) {
                com.baidu.adp.lib.util.k.c(this.cwZ.getPageContext().getPageActivity(), this.cwZ.cvX);
                if (!TextUtils.isEmpty(this.cwZ.cws) && this.cwZ.cws.trim().length() != 0) {
                    this.cwZ.cws = this.cwZ.cws.trim();
                    this.cwZ.gA(this.cwZ.cws);
                    return;
                }
                return;
            }
            this.cwZ.K(1, this.cwZ.cws);
        } else {
            z = this.cwZ.aut;
            if (z) {
                this.cwZ.akv();
            }
        }
    }
}
