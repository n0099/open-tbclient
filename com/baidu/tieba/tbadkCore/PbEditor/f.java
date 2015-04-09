package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ EditorToolComponetContainer cmE;
    private final /* synthetic */ com.baidu.tbadk.editortool.v cmF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EditorToolComponetContainer editorToolComponetContainer, com.baidu.tbadk.editortool.v vVar) {
        this.cmE = editorToolComponetContainer;
        this.cmF = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        if (i == 46) {
            this.cmE.cmh.yX();
        } else if (i == 47) {
            this.cmE.cmh.yY();
        }
        this.cmF.handleAction(i, obj);
    }
}
