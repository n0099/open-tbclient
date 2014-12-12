package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.widget.EditText;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ SquareSearchActivity brF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SquareSearchActivity squareSearchActivity) {
        this.brF = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        editText = this.brF.bqY;
        editText.requestFocus();
        Activity pageActivity = this.brF.getPageContext().getPageActivity();
        editText2 = this.brF.bqY;
        com.baidu.adp.lib.util.l.d(pageActivity, editText2);
    }
}
