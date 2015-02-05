package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.widget.EditText;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ SquareSearchActivity bta;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SquareSearchActivity squareSearchActivity) {
        this.bta = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        editText = this.bta.bsv;
        editText.requestFocus();
        Activity pageActivity = this.bta.getPageContext().getPageActivity();
        editText2 = this.bta.bsv;
        com.baidu.adp.lib.util.l.d(pageActivity, editText2);
    }
}
