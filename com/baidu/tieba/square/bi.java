package com.baidu.tieba.square;

import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2388a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(SquareSearchActivity squareSearchActivity) {
        this.f2388a = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        editText = this.f2388a.c;
        editText.requestFocus();
        SquareSearchActivity squareSearchActivity = this.f2388a;
        editText2 = this.f2388a.c;
        UtilHelper.b(squareSearchActivity, editText2);
    }
}
