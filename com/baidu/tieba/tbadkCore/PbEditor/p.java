package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ EditorToolComponetContainer bWa;
    private final /* synthetic */ com.baidu.tbadk.editortool.w bWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(EditorToolComponetContainer editorToolComponetContainer, com.baidu.tbadk.editortool.w wVar) {
        this.bWa = editorToolComponetContainer;
        this.bWb = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 46) {
            this.bWa.bVC.vz();
        } else if (i == 47) {
            this.bWa.bVC.vA();
        }
        this.bWb.handleAction(i, obj);
    }
}
