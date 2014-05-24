package com.baidu.tieba.mainentrance;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnTouchListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard;
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard2;
        EditText editText;
        EditText editText2;
        if (motionEvent.getAction() == 0) {
            linearLayoutDetectsSoftKeyboard = this.a.h;
            linearLayoutDetectsSoftKeyboard.setFocusable(true);
            linearLayoutDetectsSoftKeyboard2 = this.a.h;
            linearLayoutDetectsSoftKeyboard2.setFocusableInTouchMode(true);
            editText = this.a.c;
            if (editText.hasFocus()) {
                SquareSearchActivity squareSearchActivity = this.a;
                editText2 = this.a.c;
                com.baidu.adp.lib.util.k.a(squareSearchActivity, editText2);
                return false;
            }
            return false;
        }
        return false;
    }
}
