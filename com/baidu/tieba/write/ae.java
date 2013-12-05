package com.baidu.tieba.write;

import android.view.View;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2779a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteActivity writeActivity) {
        this.f2779a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        editorToolComponetContainer = this.f2779a.B;
        if (editorToolComponetContainer.h()) {
            editorToolComponetContainer2 = this.f2779a.B;
            editorToolComponetContainer2.i();
        }
    }
}
