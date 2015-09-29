package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnTouchListener {
    final /* synthetic */ WriteActivity dpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.dpI = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InputMethodManager inputMethodManager;
        EditText aDn;
        InputMethodManager inputMethodManager2;
        EditText aDm;
        WriteActivity writeActivity = this.dpI;
        inputMethodManager = this.dpI.mInputManager;
        aDn = this.dpI.aDn();
        writeActivity.HidenSoftKeyPad(inputMethodManager, aDn);
        WriteActivity writeActivity2 = this.dpI;
        inputMethodManager2 = this.dpI.mInputManager;
        aDm = this.dpI.aDm();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, aDm);
        return false;
    }
}
