package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnTouchListener {
    final /* synthetic */ SquareSearchActivity brF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(SquareSearchActivity squareSearchActivity) {
        this.brF = squareSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard;
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard2;
        EditText editText;
        EditText editText2;
        if (motionEvent.getAction() == 0) {
            linearLayoutDetectsSoftKeyboard = this.brF.brc;
            linearLayoutDetectsSoftKeyboard.setFocusable(true);
            linearLayoutDetectsSoftKeyboard2 = this.brF.brc;
            linearLayoutDetectsSoftKeyboard2.setFocusableInTouchMode(true);
            editText = this.brF.bqY;
            if (editText.hasFocus()) {
                Activity pageActivity = this.brF.getPageContext().getPageActivity();
                editText2 = this.brF.bqY;
                com.baidu.adp.lib.util.l.c(pageActivity, editText2);
                return false;
            }
            return false;
        }
        return false;
    }
}
