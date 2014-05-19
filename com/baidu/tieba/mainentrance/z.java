package com.baidu.tieba.mainentrance;

import android.widget.EditText;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
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
        com.baidu.adp.lib.util.h.b(squareSearchActivity, editText2);
    }
}
