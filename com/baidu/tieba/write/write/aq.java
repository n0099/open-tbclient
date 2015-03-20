package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnTouchListener {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.cyc = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        WriteActivity writeActivity = this.cyc;
        inputMethodManager = this.cyc.mInputManager;
        editText = this.cyc.cvO;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.cyc;
        inputMethodManager2 = this.cyc.mInputManager;
        editText2 = this.cyc.cvS;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        return false;
    }
}
