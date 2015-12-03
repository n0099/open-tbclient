package com.baidu.tieba.mainentrance;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnTouchListener {
    final /* synthetic */ SquareSearchActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SquareSearchActivity squareSearchActivity) {
        this.cmr = squareSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard;
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard2;
        if (motionEvent.getAction() == 0) {
            linearLayoutDetectsSoftKeyboard = this.cmr.clk;
            linearLayoutDetectsSoftKeyboard.setFocusable(true);
            linearLayoutDetectsSoftKeyboard2 = this.cmr.clk;
            linearLayoutDetectsSoftKeyboard2.setFocusableInTouchMode(true);
            if (this.cmr.cln.hasFocus()) {
                com.baidu.adp.lib.util.k.c(this.cmr.getPageContext().getPageActivity(), this.cmr.cln);
                return false;
            }
            return false;
        }
        return false;
    }
}
