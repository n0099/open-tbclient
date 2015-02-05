package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ EditorToolComponetContainer bVZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EditorToolComponetContainer editorToolComponetContainer) {
        this.bVZ = editorToolComponetContainer;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.bVZ.Yg;
        wVar.handleAction(i, obj);
    }
}
