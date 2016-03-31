package com.baidu.tieba.mainentrance;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cLU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SquareSearchActivity squareSearchActivity) {
        this.cLU = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cLU.cKS.hasFocus()) {
            com.baidu.adp.lib.util.k.c(this.cLU.getPageContext().getPageActivity(), this.cLU.cKS);
        }
        this.cLU.closeActivity();
    }
}
