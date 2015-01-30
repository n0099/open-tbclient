package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.widget.EditText;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ SquareSearchActivity btb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SquareSearchActivity squareSearchActivity) {
        this.btb = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        editText = this.btb.bsw;
        editText.requestFocus();
        Activity pageActivity = this.btb.getPageContext().getPageActivity();
        editText2 = this.btb.bsw;
        com.baidu.adp.lib.util.l.d(pageActivity, editText2);
    }
}
