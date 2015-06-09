package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnTouchListener {
    final /* synthetic */ SquareSearchActivity bCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(SquareSearchActivity squareSearchActivity) {
        this.bCF = squareSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard;
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard2;
        EditText editText;
        EditText editText2;
        if (motionEvent.getAction() == 0) {
            linearLayoutDetectsSoftKeyboard = this.bCF.bBK;
            linearLayoutDetectsSoftKeyboard.setFocusable(true);
            linearLayoutDetectsSoftKeyboard2 = this.bCF.bBK;
            linearLayoutDetectsSoftKeyboard2.setFocusableInTouchMode(true);
            editText = this.bCF.bBN;
            if (editText.hasFocus()) {
                Activity pageActivity = this.bCF.getPageContext().getPageActivity();
                editText2 = this.bCF.bBN;
                com.baidu.adp.lib.util.n.c(pageActivity, editText2);
                return false;
            }
            return false;
        }
        return false;
    }
}
