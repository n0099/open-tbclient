package com.baidu.tieba.mainentrance;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(SquareSearchActivity squareSearchActivity) {
        this.bVC = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bVC.abo();
    }
}
