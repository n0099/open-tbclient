package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnTouchListener {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.k kVar;
        EditText editText;
        if (motionEvent.getAction() == 1) {
            view.requestFocus();
            kVar = this.dYD.aso;
            kVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            editText = this.dYD.dUQ;
            editText.requestFocus();
            return false;
        }
        return false;
    }
}
