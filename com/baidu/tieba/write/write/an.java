package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnTouchListener {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InputMethodManager inputMethodManager;
        EditText aEn;
        InputMethodManager inputMethodManager2;
        EditText aEm;
        WriteActivity writeActivity = this.dsa;
        inputMethodManager = this.dsa.mInputManager;
        aEn = this.dsa.aEn();
        writeActivity.HidenSoftKeyPad(inputMethodManager, aEn);
        WriteActivity writeActivity2 = this.dsa;
        inputMethodManager2 = this.dsa.mInputManager;
        aEm = this.dsa.aEm();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, aEm);
        return false;
    }
}
