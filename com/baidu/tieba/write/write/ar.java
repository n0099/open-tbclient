package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnTouchListener {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.cCP = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        WriteActivity writeActivity = this.cCP;
        inputMethodManager = this.cCP.mInputManager;
        editText = this.cCP.cAu;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.cCP;
        inputMethodManager2 = this.cCP.mInputManager;
        editText2 = this.cCP.cAy;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        return false;
    }
}
