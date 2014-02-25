package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText2;
        editText = this.a.j;
        editText.requestFocus();
        writeEditorToolButtonContainer = this.a.A;
        writeEditorToolButtonContainer.c();
        editorToolComponetContainer = this.a.B;
        editorToolComponetContainer.l();
        editorToolComponetContainer2 = this.a.B;
        editText2 = this.a.j;
        editorToolComponetContainer2.a(editText2);
    }
}
