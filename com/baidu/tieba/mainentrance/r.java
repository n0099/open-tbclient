package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.a.c;
        if (editText.hasFocus()) {
            SquareSearchActivity squareSearchActivity = this.a;
            editText2 = this.a.c;
            com.baidu.adp.lib.util.k.a(squareSearchActivity, editText2);
            this.a.closeActivity();
        }
    }
}
