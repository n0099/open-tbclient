package com.baidu.tieba.write;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        by byVar;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        textView = this.a.M;
        textView.setSelected(true);
        byVar = this.a.N;
        byVar.showAsDropDown(view, 0, com.baidu.adp.lib.util.h.a((Context) this.a, 1.0f));
        writeEditorToolButtonContainer = this.a.z;
        writeEditorToolButtonContainer.c();
        editorToolComponetContainer = this.a.A;
        editorToolComponetContainer.m();
    }
}
