package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ EditorToolComponetContainer cqD;
    private final /* synthetic */ com.baidu.tbadk.editortool.v cqE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EditorToolComponetContainer editorToolComponetContainer, com.baidu.tbadk.editortool.v vVar) {
        this.cqD = editorToolComponetContainer;
        this.cqE = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        if (i == 46) {
            this.cqD.cqf.zK();
        } else if (i == 47) {
            this.cqD.cqf.zL();
        } else if (i == 4) {
            this.cqD.anB();
        }
        this.cqE.handleAction(i, obj);
    }
}
