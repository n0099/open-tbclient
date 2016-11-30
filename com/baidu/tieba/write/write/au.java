package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnTouchListener {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.l lVar;
        EditText editText;
        if (motionEvent.getAction() == 1) {
            view.requestFocus();
            lVar = this.gpp.auI;
            lVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            editText = this.gpp.fsQ;
            editText.requestFocus();
            return false;
        }
        return false;
    }
}
