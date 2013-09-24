package com.baidu.tieba.square;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f1826a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(SquareSearchActivity squareSearchActivity) {
        this.f1826a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.f1826a.c;
        editText.setText("");
    }
}
