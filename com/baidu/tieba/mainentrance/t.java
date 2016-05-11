package com.baidu.tieba.mainentrance;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SquareSearchActivity squareSearchActivity) {
        this.cMQ = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cMQ.cLO.hasFocus()) {
            com.baidu.adp.lib.util.k.a(this.cMQ.getPageContext().getPageActivity(), this.cMQ.cLO);
        }
        this.cMQ.closeActivity();
    }
}
