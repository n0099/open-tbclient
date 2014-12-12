package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity brF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SquareSearchActivity squareSearchActivity) {
        this.brF = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.brF.bqY;
        if (editText.hasFocus()) {
            Activity pageActivity = this.brF.getPageContext().getPageActivity();
            editText2 = this.brF.bqY;
            com.baidu.adp.lib.util.l.c(pageActivity, editText2);
            this.brF.closeActivity();
        }
    }
}
