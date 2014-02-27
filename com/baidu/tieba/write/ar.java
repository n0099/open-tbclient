package com.baidu.tieba.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
final class ar implements View.OnTouchListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText;
        if (motionEvent.getAction() == 1) {
            writeEditorToolButtonContainer = this.a.A;
            writeEditorToolButtonContainer.c();
            editorToolComponetContainer = this.a.B;
            editText = this.a.j;
            editorToolComponetContainer.c(editText);
            return false;
        }
        return false;
    }
}
