package com.baidu.tieba.mainentrance;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(SquareSearchActivity squareSearchActivity) {
        this.bQZ = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bQZ.bQb.hasFocus()) {
            com.baidu.adp.lib.util.k.c(this.bQZ.getPageContext().getPageActivity(), this.bQZ.bQb);
            this.bQZ.closeActivity();
        }
    }
}
