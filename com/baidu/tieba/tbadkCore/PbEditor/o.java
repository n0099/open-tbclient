package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ EditorToolComponetContainer bUi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EditorToolComponetContainer editorToolComponetContainer) {
        this.bUi = editorToolComponetContainer;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.bUi.XD;
        wVar.handleAction(i, obj);
    }
}
