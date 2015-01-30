package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements DialogInterface.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer bWa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(EditorToolComponetContainer editorToolComponetContainer) {
        this.bWa = editorToolComponetContainer;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.editortool.w wVar;
        this.bWa.bVC.setmImagetype(2);
        wVar = this.bWa.Yj;
        wVar.handleAction(23, null);
    }
}
