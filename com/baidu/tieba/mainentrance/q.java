package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.widget.EditText;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ SquareSearchActivity bzT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(SquareSearchActivity squareSearchActivity) {
        this.bzT = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        editText = this.bzT.bze;
        editText.requestFocus();
        Activity pageActivity = this.bzT.getPageContext().getPageActivity();
        editText2 = this.bzT.bze;
        com.baidu.adp.lib.util.n.d(pageActivity, editText2);
    }
}
