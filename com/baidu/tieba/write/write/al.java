package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnTouchListener {
    final /* synthetic */ WriteActivity ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.ddQ = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InputMethodManager inputMethodManager;
        EditText azL;
        InputMethodManager inputMethodManager2;
        EditText azK;
        WriteActivity writeActivity = this.ddQ;
        inputMethodManager = this.ddQ.mInputManager;
        azL = this.ddQ.azL();
        writeActivity.HidenSoftKeyPad(inputMethodManager, azL);
        WriteActivity writeActivity2 = this.ddQ;
        inputMethodManager2 = this.ddQ.mInputManager;
        azK = this.ddQ.azK();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, azK);
        return false;
    }
}
