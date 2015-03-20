package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnTouchListener {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SquareSearchActivity squareSearchActivity) {
        this.bzG = squareSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard;
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard2;
        EditText editText;
        EditText editText2;
        if (motionEvent.getAction() == 0) {
            linearLayoutDetectsSoftKeyboard = this.bzG.byP;
            linearLayoutDetectsSoftKeyboard.setFocusable(true);
            linearLayoutDetectsSoftKeyboard2 = this.bzG.byP;
            linearLayoutDetectsSoftKeyboard2.setFocusableInTouchMode(true);
            editText = this.bzG.byS;
            if (editText.hasFocus()) {
                Activity pageActivity = this.bzG.getPageContext().getPageActivity();
                editText2 = this.bzG.byS;
                com.baidu.adp.lib.util.n.c(pageActivity, editText2);
                return false;
            }
            return false;
        }
        return false;
    }
}
