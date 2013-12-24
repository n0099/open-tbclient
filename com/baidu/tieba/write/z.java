package com.baidu.tieba.write;

import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tieba.editortool.o {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText;
        editorToolComponetContainer = this.a.B;
        editText = this.a.h;
        editorToolComponetContainer.c(editText);
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
