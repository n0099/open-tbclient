package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements DialogInterface.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer bVZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(EditorToolComponetContainer editorToolComponetContainer) {
        this.bVZ = editorToolComponetContainer;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.editortool.w wVar;
        this.bVZ.bVB.setmImagetype(2);
        wVar = this.bVZ.Yg;
        wVar.handleAction(23, null);
    }
}
