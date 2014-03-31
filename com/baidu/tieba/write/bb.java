package com.baidu.tieba.write;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bb implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView;
        bs bsVar;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        textView = this.a.M;
        textView.setSelected(true);
        bsVar = this.a.N;
        bsVar.showAsDropDown(view, 0, com.baidu.adp.lib.util.i.a((Context) this.a, 1.0f));
        writeEditorToolButtonContainer = this.a.z;
        writeEditorToolButtonContainer.c();
        editorToolComponetContainer = this.a.A;
        editorToolComponetContainer.b();
    }
}
