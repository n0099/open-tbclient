package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.a.c;
        UtilHelper.i(this.a, editText.getText().toString().trim());
    }
}
