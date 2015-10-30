package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnTouchListener {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.dqi = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InputMethodManager inputMethodManager;
        EditText aDt;
        InputMethodManager inputMethodManager2;
        EditText aDs;
        WriteActivity writeActivity = this.dqi;
        inputMethodManager = this.dqi.mInputManager;
        aDt = this.dqi.aDt();
        writeActivity.HidenSoftKeyPad(inputMethodManager, aDt);
        WriteActivity writeActivity2 = this.dqi;
        inputMethodManager2 = this.dqi.mInputManager;
        aDs = this.dqi.aDs();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, aDs);
        return false;
    }
}
