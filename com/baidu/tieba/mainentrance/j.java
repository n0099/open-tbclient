package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
final class j implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        editText = this.a.c;
        editText.setText("");
    }
}
