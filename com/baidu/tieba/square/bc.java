package com.baidu.tieba.square;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2397a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(SquareSearchActivity squareSearchActivity) {
        this.f2397a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.f2397a.c;
        UtilHelper.i(this.f2397a, editText.getText().toString().trim());
    }
}
