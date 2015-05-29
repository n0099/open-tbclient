package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(SquareSearchActivity squareSearchActivity) {
        this.bCE = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.bCE.bBM;
        if (editText.hasFocus()) {
            Activity pageActivity = this.bCE.getPageContext().getPageActivity();
            editText2 = this.bCE.bBM;
            com.baidu.adp.lib.util.n.c(pageActivity, editText2);
            this.bCE.closeActivity();
        }
    }
}
