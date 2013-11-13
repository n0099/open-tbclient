package com.baidu.tieba.write;

import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tieba.editortool.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2724a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(WriteActivity writeActivity) {
        this.f2724a = writeActivity;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        EditorToolComponetContainer editorToolComponetContainer;
        editorToolComponetContainer = this.f2724a.B;
        editorToolComponetContainer.i();
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
