package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ EditorToolComponetContainer bWa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EditorToolComponetContainer editorToolComponetContainer) {
        this.bWa = editorToolComponetContainer;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.bWa.Yj;
        wVar.handleAction(i, obj);
    }
}
