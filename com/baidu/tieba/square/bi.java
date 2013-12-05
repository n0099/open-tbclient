package com.baidu.tieba.square;

import android.widget.EditText;
/* loaded from: classes.dex */
class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2505a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(SquareSearchActivity squareSearchActivity) {
        this.f2505a = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        editText = this.f2505a.c;
        editText.requestFocus();
        SquareSearchActivity squareSearchActivity = this.f2505a;
        editText2 = this.f2505a.c;
        com.baidu.adp.lib.h.g.b(squareSearchActivity, editText2);
    }
}
