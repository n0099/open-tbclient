package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ EditorToolComponetContainer cmo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EditorToolComponetContainer editorToolComponetContainer) {
        this.cmo = editorToolComponetContainer;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.editortool.v vVar;
        vVar = this.cmo.aip;
        vVar.handleAction(i, obj);
    }
}
