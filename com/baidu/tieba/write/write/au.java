package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnTouchListener {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.j jVar;
        EditText editText;
        if (motionEvent.getAction() == 1) {
            view.requestFocus();
            jVar = this.fDQ.aun;
            jVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            editText = this.fDQ.eWJ;
            editText.requestFocus();
            return false;
        }
        return false;
    }
}
