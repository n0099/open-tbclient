package com.baidu.tieba.write;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* loaded from: classes.dex */
class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2674a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(WriteActivity writeActivity) {
        this.f2674a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        InputMethodManager inputMethodManager;
        EditText editText2;
        InputMethodManager inputMethodManager2;
        EditText editText3;
        editText = this.f2674a.e;
        if (editText.getVisibility() == 0) {
            WriteActivity writeActivity = this.f2674a;
            inputMethodManager2 = this.f2674a.d;
            editText3 = this.f2674a.e;
            writeActivity.b(inputMethodManager2, editText3);
            return;
        }
        WriteActivity writeActivity2 = this.f2674a;
        inputMethodManager = this.f2674a.d;
        editText2 = this.f2674a.g;
        writeActivity2.b(inputMethodManager, editText2);
    }
}
