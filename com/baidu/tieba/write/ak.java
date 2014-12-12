package com.baidu.tieba.write;

import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnTouchListener {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        WriteActivity writeActivity = this.cft;
        inputMethodManager = this.cft.mInputManager;
        editText = this.cft.bNW;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.cft;
        inputMethodManager2 = this.cft.mInputManager;
        editText2 = this.cft.bOa;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        return false;
    }
}
