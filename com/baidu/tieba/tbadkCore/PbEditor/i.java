package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer cqD;
    private final /* synthetic */ int cqF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EditorToolComponetContainer editorToolComponetContainer, int i) {
        this.cqD = editorToolComponetContainer;
        this.cqF = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.v vVar;
        vVar = this.cqD.ajx;
        vVar.handleAction(this.cqF, null);
    }
}
