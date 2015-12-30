package com.baidu.tieba.mainentrance;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnTouchListener {
    final /* synthetic */ SquareSearchActivity cqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SquareSearchActivity squareSearchActivity) {
        this.cqu = squareSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard;
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard2;
        if (motionEvent.getAction() == 0) {
            linearLayoutDetectsSoftKeyboard = this.cqu.cpo;
            linearLayoutDetectsSoftKeyboard.setFocusable(true);
            linearLayoutDetectsSoftKeyboard2 = this.cqu.cpo;
            linearLayoutDetectsSoftKeyboard2.setFocusableInTouchMode(true);
            if (this.cqu.cpr.hasFocus()) {
                com.baidu.adp.lib.util.k.c(this.cqu.getPageContext().getPageActivity(), this.cqu.cpr);
                return false;
            }
            return false;
        }
        return false;
    }
}
