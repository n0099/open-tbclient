package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnTouchListener {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InputMethodManager inputMethodManager;
        EditText aMf;
        InputMethodManager inputMethodManager2;
        EditText aMe;
        WriteActivity writeActivity = this.dYD;
        inputMethodManager = this.dYD.mInputManager;
        aMf = this.dYD.aMf();
        writeActivity.HidenSoftKeyPad(inputMethodManager, aMf);
        WriteActivity writeActivity2 = this.dYD;
        inputMethodManager2 = this.dYD.mInputManager;
        aMe = this.dYD.aMe();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, aMe);
        return false;
    }
}
