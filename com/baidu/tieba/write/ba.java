package com.baidu.tieba.write;

import android.view.View;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
class ba implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        editorToolComponetContainer = this.a.B;
        if (editorToolComponetContainer.j()) {
            editorToolComponetContainer2 = this.a.B;
            editorToolComponetContainer2.k();
        }
    }
}
