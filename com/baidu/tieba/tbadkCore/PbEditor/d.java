package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ EditorToolComponetContainer cqE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EditorToolComponetContainer editorToolComponetContainer) {
        this.cqE = editorToolComponetContainer;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.editortool.v vVar;
        vVar = this.cqE.ajx;
        vVar.handleAction(i, obj);
    }
}
