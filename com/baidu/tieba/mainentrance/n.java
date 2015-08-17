package com.baidu.tieba.mainentrance;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnTouchListener {
    final /* synthetic */ SquareSearchActivity bQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SquareSearchActivity squareSearchActivity) {
        this.bQZ = squareSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard;
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard2;
        if (motionEvent.getAction() == 0) {
            linearLayoutDetectsSoftKeyboard = this.bQZ.bPY;
            linearLayoutDetectsSoftKeyboard.setFocusable(true);
            linearLayoutDetectsSoftKeyboard2 = this.bQZ.bPY;
            linearLayoutDetectsSoftKeyboard2.setFocusableInTouchMode(true);
            if (this.bQZ.bQb.hasFocus()) {
                com.baidu.adp.lib.util.k.c(this.bQZ.getPageContext().getPageActivity(), this.bQZ.bQb);
                return false;
            }
            return false;
        }
        return false;
    }
}
