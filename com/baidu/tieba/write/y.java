package com.baidu.tieba.write;

import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tieba.editortool.o {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        EditorToolComponetContainer editorToolComponetContainer;
        editorToolComponetContainer = this.a.B;
        editorToolComponetContainer.i();
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
