package com.baidu.tieba.mainentrance;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnFocusChangeListener {
    final /* synthetic */ SquareSearchActivity bVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SquareSearchActivity squareSearchActivity) {
        this.bVr = squareSearchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.k.c(this.bVr.getPageContext().getPageActivity(), view);
        }
    }
}
