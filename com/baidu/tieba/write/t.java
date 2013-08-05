package com.baidu.tieba.write;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* loaded from: classes.dex */
class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1915a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(WriteActivity writeActivity) {
        this.f1915a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        InputMethodManager inputMethodManager;
        EditText editText2;
        InputMethodManager inputMethodManager2;
        EditText editText3;
        editText = this.f1915a.e;
        if (editText.getVisibility() == 0) {
            WriteActivity writeActivity = this.f1915a;
            inputMethodManager2 = this.f1915a.d;
            editText3 = this.f1915a.e;
            writeActivity.b(inputMethodManager2, editText3);
            return;
        }
        WriteActivity writeActivity2 = this.f1915a;
        inputMethodManager = this.f1915a.d;
        editText2 = this.f1915a.f;
        writeActivity2.b(inputMethodManager, editText2);
    }
}
