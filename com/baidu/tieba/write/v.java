package com.baidu.tieba.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2823a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(WriteActivity writeActivity) {
        this.f2823a = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText;
        if (motionEvent.getAction() == 1) {
            writeEditorToolButtonContainer = this.f2823a.A;
            writeEditorToolButtonContainer.c();
            editorToolComponetContainer = this.f2823a.B;
            editText = this.f2823a.h;
            editorToolComponetContainer.c(editText);
            return false;
        }
        return false;
    }
}
