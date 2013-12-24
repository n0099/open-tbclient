package com.baidu.tieba.square;

import android.widget.EditText;
/* loaded from: classes.dex */
class bi implements Runnable {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        editText = this.a.c;
        editText.requestFocus();
        SquareSearchActivity squareSearchActivity = this.a;
        editText2 = this.a.c;
        com.baidu.adp.lib.h.g.b(squareSearchActivity, editText2);
    }
}
