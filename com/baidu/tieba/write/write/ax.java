package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnTouchListener {
    final /* synthetic */ WriteActivity dpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity) {
        this.dpI = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.j jVar;
        EditText editText;
        if (motionEvent.getAction() == 1) {
            view.requestFocus();
            jVar = this.dpI.dpc;
            jVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            editText = this.dpI.dmd;
            editText.requestFocus();
            return false;
        }
        return false;
    }
}
