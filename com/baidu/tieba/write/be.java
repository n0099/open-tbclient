package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText2;
        editText = this.a.h;
        editText.requestFocus();
        writeEditorToolButtonContainer = this.a.z;
        writeEditorToolButtonContainer.c();
        editorToolComponetContainer = this.a.A;
        editorToolComponetContainer.n();
        editorToolComponetContainer2 = this.a.A;
        editText2 = this.a.h;
        editorToolComponetContainer2.a(editText2);
    }
}
