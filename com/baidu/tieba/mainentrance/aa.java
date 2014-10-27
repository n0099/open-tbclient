package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bmO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SquareSearchActivity squareSearchActivity) {
        this.bmO = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.bmO.bmh;
        if (editText.hasFocus()) {
            SquareSearchActivity squareSearchActivity = this.bmO;
            editText2 = this.bmO.bmh;
            com.baidu.adp.lib.util.m.b(squareSearchActivity, editText2);
            this.bmO.closeActivity();
        }
    }
}
