package com.baidu.tieba.mainentrance;

import android.widget.EditText;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ SquareSearchActivity bnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SquareSearchActivity squareSearchActivity) {
        this.bnc = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        editText = this.bnc.bmv;
        editText.requestFocus();
        SquareSearchActivity squareSearchActivity = this.bnc;
        editText2 = this.bnc.bmv;
        com.baidu.adp.lib.util.m.c(squareSearchActivity, editText2);
    }
}
