package com.baidu.tieba.write;

import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
class ap implements Runnable {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText3;
        editText = this.a.g;
        if (editText.getVisibility() == 0) {
            editorToolComponetContainer2 = this.a.B;
            editText3 = this.a.g;
            editorToolComponetContainer2.c(editText3);
            return;
        }
        editorToolComponetContainer = this.a.B;
        editText2 = this.a.j;
        editorToolComponetContainer.c(editText2);
    }
}
