package com.baidu.tieba.write;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        InputMethodManager inputMethodManager;
        EditText editText2;
        InputMethodManager inputMethodManager2;
        EditText editText3;
        editText = this.a.f;
        if (editText.getVisibility() == 0) {
            WriteActivity writeActivity = this.a;
            inputMethodManager2 = this.a.e;
            editText3 = this.a.f;
            writeActivity.ShowSoftKeyPad(inputMethodManager2, editText3);
            return;
        }
        WriteActivity writeActivity2 = this.a;
        inputMethodManager = this.a.e;
        editText2 = this.a.h;
        writeActivity2.ShowSoftKeyPad(inputMethodManager, editText2);
    }
}
