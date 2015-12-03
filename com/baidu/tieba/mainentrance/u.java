package com.baidu.tieba.mainentrance;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SquareSearchActivity squareSearchActivity) {
        this.cmr = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cmr.cln.hasFocus()) {
            com.baidu.adp.lib.util.k.c(this.cmr.getPageContext().getPageActivity(), this.cmr.cln);
            this.cmr.closeActivity();
        }
    }
}
