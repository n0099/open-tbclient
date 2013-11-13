package com.baidu.tieba.square;

import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class bk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2405a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(SquareSearchActivity squareSearchActivity) {
        this.f2405a = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        editText = this.f2405a.c;
        editText.requestFocus();
        SquareSearchActivity squareSearchActivity = this.f2405a;
        editText2 = this.f2405a.c;
        UtilHelper.b(squareSearchActivity, editText2);
    }
}
