package com.baidu.tieba.mainentrance;

import android.widget.EditText;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ SquareSearchActivity bmO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SquareSearchActivity squareSearchActivity) {
        this.bmO = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        editText = this.bmO.bmh;
        editText.requestFocus();
        SquareSearchActivity squareSearchActivity = this.bmO;
        editText2 = this.bmO.bmh;
        com.baidu.adp.lib.util.m.c(squareSearchActivity, editText2);
    }
}
