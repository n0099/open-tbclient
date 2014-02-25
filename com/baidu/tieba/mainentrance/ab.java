package com.baidu.tieba.mainentrance;

import android.widget.EditText;
import com.baidu.adp.lib.util.BdUtilHelper;
/* loaded from: classes.dex */
class ab implements Runnable {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SquareSearchActivity squareSearchActivity) {
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
        BdUtilHelper.b(squareSearchActivity, editText2);
    }
}
