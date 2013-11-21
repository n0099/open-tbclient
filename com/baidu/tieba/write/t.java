package com.baidu.tieba.write;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* loaded from: classes.dex */
class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2703a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(WriteActivity writeActivity) {
        this.f2703a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        InputMethodManager inputMethodManager;
        EditText editText2;
        InputMethodManager inputMethodManager2;
        EditText editText3;
        editText = this.f2703a.f;
        if (editText.getVisibility() == 0) {
            WriteActivity writeActivity = this.f2703a;
            inputMethodManager2 = this.f2703a.e;
            editText3 = this.f2703a.f;
            writeActivity.ShowSoftKeyPad(inputMethodManager2, editText3);
            return;
        }
        WriteActivity writeActivity2 = this.f2703a;
        inputMethodManager = this.f2703a.e;
        editText2 = this.f2703a.h;
        writeActivity2.ShowSoftKeyPad(inputMethodManager, editText2);
    }
}
