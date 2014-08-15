package com.baidu.tieba.write;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        bz bzVar;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        textView = this.a.O;
        textView.setSelected(true);
        bzVar = this.a.P;
        com.baidu.adp.lib.e.d.a(bzVar, view, 0, com.baidu.adp.lib.util.j.a((Context) this.a, 1.0f));
        writeEditorToolButtonContainer = this.a.B;
        writeEditorToolButtonContainer.c();
        editorToolComponetContainer = this.a.C;
        editorToolComponetContainer.p();
    }
}
