package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnTouchListener {
    final /* synthetic */ SquareSearchActivity bCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(SquareSearchActivity squareSearchActivity) {
        this.bCE = squareSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard;
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard2;
        EditText editText;
        EditText editText2;
        if (motionEvent.getAction() == 0) {
            linearLayoutDetectsSoftKeyboard = this.bCE.bBJ;
            linearLayoutDetectsSoftKeyboard.setFocusable(true);
            linearLayoutDetectsSoftKeyboard2 = this.bCE.bBJ;
            linearLayoutDetectsSoftKeyboard2.setFocusableInTouchMode(true);
            editText = this.bCE.bBM;
            if (editText.hasFocus()) {
                Activity pageActivity = this.bCE.getPageContext().getPageActivity();
                editText2 = this.bCE.bBM;
                com.baidu.adp.lib.util.n.c(pageActivity, editText2);
                return false;
            }
            return false;
        }
        return false;
    }
}
