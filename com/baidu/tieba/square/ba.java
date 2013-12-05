package com.baidu.tieba.square;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2497a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(SquareSearchActivity squareSearchActivity) {
        this.f2497a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.f2497a.c;
        UtilHelper.h(this.f2497a, editText.getText().toString().trim());
    }
}
