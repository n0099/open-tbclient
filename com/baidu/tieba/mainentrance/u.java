package com.baidu.tieba.mainentrance;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SquareSearchActivity squareSearchActivity) {
        this.bWd = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bWd.bVb.hasFocus()) {
            com.baidu.adp.lib.util.k.c(this.bWd.getPageContext().getPageActivity(), this.bWd.bVb);
            this.bWd.closeActivity();
        }
    }
}
