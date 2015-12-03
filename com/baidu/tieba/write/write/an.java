package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnTouchListener {
    final /* synthetic */ WriteActivity dRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.dRf = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InputMethodManager inputMethodManager;
        EditText aJK;
        InputMethodManager inputMethodManager2;
        EditText aJJ;
        WriteActivity writeActivity = this.dRf;
        inputMethodManager = this.dRf.mInputManager;
        aJK = this.dRf.aJK();
        writeActivity.HidenSoftKeyPad(inputMethodManager, aJK);
        WriteActivity writeActivity2 = this.dRf;
        inputMethodManager2 = this.dRf.mInputManager;
        aJJ = this.dRf.aJJ();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, aJJ);
        return false;
    }
}
