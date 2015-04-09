package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer cmE;
    private final /* synthetic */ int cmG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EditorToolComponetContainer editorToolComponetContainer, int i) {
        this.cmE = editorToolComponetContainer;
        this.cmG = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.v vVar;
        vVar = this.cmE.aix;
        vVar.handleAction(this.cmG, null);
    }
}
