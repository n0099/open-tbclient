package com.baidu.tieba.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
final class am implements View.OnTouchListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText;
        if (motionEvent.getAction() == 1) {
            view.requestFocus();
            writeEditorToolButtonContainer = this.a.z;
            writeEditorToolButtonContainer.c();
            editorToolComponetContainer = this.a.A;
            editText = this.a.h;
            editorToolComponetContainer.c(editText);
            return false;
        }
        return false;
    }
}
