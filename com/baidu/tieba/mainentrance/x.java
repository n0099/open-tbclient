package com.baidu.tieba.mainentrance;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SquareSearchActivity squareSearchActivity) {
        this.bVr = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bVr.bUp.setText("");
    }
}
