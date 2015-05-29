package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SquareSearchActivity squareSearchActivity) {
        this.bCE = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.bCE.bBM;
        editText.setText("");
    }
}
