package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bzT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SquareSearchActivity squareSearchActivity) {
        this.bzT = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.bzT.bze;
        if (editText.hasFocus()) {
            Activity pageActivity = this.bzT.getPageContext().getPageActivity();
            editText2 = this.bzT.bze;
            com.baidu.adp.lib.util.n.c(pageActivity, editText2);
            this.bzT.closeActivity();
        }
    }
}
