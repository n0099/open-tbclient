package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.widget.EditText;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ SquareSearchActivity bCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SquareSearchActivity squareSearchActivity) {
        this.bCF = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        editText = this.bCF.bBN;
        editText.requestFocus();
        Activity pageActivity = this.bCF.getPageContext().getPageActivity();
        editText2 = this.bCF.bBN;
        com.baidu.adp.lib.util.n.d(pageActivity, editText2);
    }
}
