package com.baidu.tieba.mainentrance;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SquareSearchActivity squareSearchActivity) {
        this.bVC = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bVC.bUA.hasFocus()) {
            com.baidu.adp.lib.util.k.c(this.bVC.getPageContext().getPageActivity(), this.bVC.bUA);
            this.bVC.closeActivity();
        }
    }
}
