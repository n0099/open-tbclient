package com.baidu.tieba.mainentrance;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnTouchListener {
    final /* synthetic */ SquareSearchActivity bnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(SquareSearchActivity squareSearchActivity) {
        this.bnc = squareSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard;
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard2;
        EditText editText;
        EditText editText2;
        if (motionEvent.getAction() == 0) {
            linearLayoutDetectsSoftKeyboard = this.bnc.bmz;
            linearLayoutDetectsSoftKeyboard.setFocusable(true);
            linearLayoutDetectsSoftKeyboard2 = this.bnc.bmz;
            linearLayoutDetectsSoftKeyboard2.setFocusableInTouchMode(true);
            editText = this.bnc.bmv;
            if (editText.hasFocus()) {
                SquareSearchActivity squareSearchActivity = this.bnc;
                editText2 = this.bnc.bmv;
                com.baidu.adp.lib.util.m.b(squareSearchActivity, editText2);
                return false;
            }
            return false;
        }
        return false;
    }
}
