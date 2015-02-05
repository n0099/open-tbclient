package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ EditorToolComponetContainer bVZ;
    private final /* synthetic */ com.baidu.tbadk.editortool.w bWa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(EditorToolComponetContainer editorToolComponetContainer, com.baidu.tbadk.editortool.w wVar) {
        this.bVZ = editorToolComponetContainer;
        this.bWa = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 46) {
            this.bVZ.bVB.vt();
        } else if (i == 47) {
            this.bVZ.bVB.vu();
        }
        this.bWa.handleAction(i, obj);
    }
}
