package com.baidu.tieba.write;

import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
class ao implements Runnable {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText3;
        editText = this.a.f;
        if (editText.getVisibility() == 0) {
            editorToolComponetContainer2 = this.a.C;
            editText3 = this.a.f;
            editorToolComponetContainer2.c(editText3);
            return;
        }
        editorToolComponetContainer = this.a.C;
        editText2 = this.a.i;
        editorToolComponetContainer.c(editText2);
    }
}
