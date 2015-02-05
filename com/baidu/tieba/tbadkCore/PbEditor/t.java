package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer bVZ;
    private final /* synthetic */ int bWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(EditorToolComponetContainer editorToolComponetContainer, int i) {
        this.bVZ = editorToolComponetContainer;
        this.bWb = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.bVZ.Yg;
        wVar.handleAction(this.bWb, null);
    }
}
