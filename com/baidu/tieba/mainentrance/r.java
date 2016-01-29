package com.baidu.tieba.mainentrance;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnTouchListener {
    final /* synthetic */ SquareSearchActivity cwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SquareSearchActivity squareSearchActivity) {
        this.cwZ = squareSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard;
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard2;
        if (motionEvent.getAction() == 0) {
            linearLayoutDetectsSoftKeyboard = this.cwZ.cvU;
            linearLayoutDetectsSoftKeyboard.setFocusable(true);
            linearLayoutDetectsSoftKeyboard2 = this.cwZ.cvU;
            linearLayoutDetectsSoftKeyboard2.setFocusableInTouchMode(true);
            if (this.cwZ.cvX.hasFocus()) {
                com.baidu.adp.lib.util.k.c(this.cwZ.getPageContext().getPageActivity(), this.cwZ.cvX);
                return false;
            }
            return false;
        }
        return false;
    }
}
