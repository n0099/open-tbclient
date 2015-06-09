package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ EditorToolComponetContainer cqE;
    private final /* synthetic */ com.baidu.tbadk.editortool.v cqF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EditorToolComponetContainer editorToolComponetContainer, com.baidu.tbadk.editortool.v vVar) {
        this.cqE = editorToolComponetContainer;
        this.cqF = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        if (i == 46) {
            this.cqE.cqg.zL();
        } else if (i == 47) {
            this.cqE.cqg.zM();
        } else if (i == 4) {
            this.cqE.anC();
        }
        this.cqF.handleAction(i, obj);
    }
}
