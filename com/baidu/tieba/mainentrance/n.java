package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.widget.EditText;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ SquareSearchActivity bCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SquareSearchActivity squareSearchActivity) {
        this.bCE = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        editText = this.bCE.bBM;
        editText.requestFocus();
        Activity pageActivity = this.bCE.getPageContext().getPageActivity();
        editText2 = this.bCE.bBM;
        com.baidu.adp.lib.util.n.d(pageActivity, editText2);
    }
}
