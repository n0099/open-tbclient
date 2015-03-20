package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer cmo;
    private final /* synthetic */ int cmq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EditorToolComponetContainer editorToolComponetContainer, int i) {
        this.cmo = editorToolComponetContainer;
        this.cmq = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.v vVar;
        vVar = this.cmo.aip;
        vVar.handleAction(this.cmq, null);
    }
}
