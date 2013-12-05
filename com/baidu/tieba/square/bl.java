package com.baidu.tieba.square;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2508a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(SquareSearchActivity squareSearchActivity) {
        this.f2508a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.f2508a.c;
        editText.setText("");
    }
}
