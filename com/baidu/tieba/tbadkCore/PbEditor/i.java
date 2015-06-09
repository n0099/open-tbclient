package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer cqE;
    private final /* synthetic */ int cqG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EditorToolComponetContainer editorToolComponetContainer, int i) {
        this.cqE = editorToolComponetContainer;
        this.cqG = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.v vVar;
        vVar = this.cqE.ajx;
        vVar.handleAction(this.cqG, null);
    }
}
