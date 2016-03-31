package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnTouchListener {
    final /* synthetic */ WriteActivity eNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity) {
        this.eNd = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.l lVar;
        EditText editText;
        if (motionEvent.getAction() == 1) {
            view.requestFocus();
            lVar = this.eNd.atG;
            lVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            editText = this.eNd.eJr;
            editText.requestFocus();
            return false;
        }
        return false;
    }
}
