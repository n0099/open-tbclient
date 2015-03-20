package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.widget.EditText;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SquareSearchActivity squareSearchActivity) {
        this.bzG = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        editText = this.bzG.byS;
        editText.requestFocus();
        Activity pageActivity = this.bzG.getPageContext().getPageActivity();
        editText2 = this.bzG.byS;
        com.baidu.adp.lib.util.n.d(pageActivity, editText2);
    }
}
