package com.baidu.tieba.write;

import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tieba.editortool.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2725a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WriteActivity writeActivity) {
        this.f2725a = writeActivity;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText;
        editorToolComponetContainer = this.f2725a.B;
        editText = this.f2725a.h;
        editorToolComponetContainer.c(editText);
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
