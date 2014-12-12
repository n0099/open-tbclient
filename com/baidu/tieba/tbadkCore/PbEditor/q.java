package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements DialogInterface.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer bUi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(EditorToolComponetContainer editorToolComponetContainer) {
        this.bUi = editorToolComponetContainer;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.editortool.w wVar;
        this.bUi.bTK.setmImagetype(2);
        wVar = this.bUi.XD;
        wVar.handleAction(23, null);
    }
}
