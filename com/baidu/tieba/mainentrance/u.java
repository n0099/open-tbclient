package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SquareSearchActivity squareSearchActivity) {
        this.bzG = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.bzG.byS;
        if (editText.hasFocus()) {
            Activity pageActivity = this.bzG.getPageContext().getPageActivity();
            editText2 = this.bzG.byS;
            com.baidu.adp.lib.util.n.c(pageActivity, editText2);
            this.bzG.closeActivity();
        }
    }
}
