package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnTouchListener {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity) {
        this.ets = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.k kVar;
        EditText editText;
        if (motionEvent.getAction() == 1) {
            view.requestFocus();
            kVar = this.ets.ath;
            kVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            editText = this.ets.epv;
            editText.requestFocus();
            return false;
        }
        return false;
    }
}
