package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ EditorToolComponetContainer bUi;
    private final /* synthetic */ com.baidu.tbadk.editortool.w bUj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(EditorToolComponetContainer editorToolComponetContainer, com.baidu.tbadk.editortool.w wVar) {
        this.bUi = editorToolComponetContainer;
        this.bUj = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 46) {
            this.bUi.bTK.vi();
        } else if (i == 47) {
            this.bUi.bTK.vj();
        }
        this.bUj.handleAction(i, obj);
    }
}
