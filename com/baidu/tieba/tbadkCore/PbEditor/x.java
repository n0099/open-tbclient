package com.baidu.tieba.tbadkCore.PbEditor;
/* loaded from: classes.dex */
class x implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aKR;
    final /* synthetic */ PbEditorToolView cre;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.v vVar) {
        this.cre = pbEditorToolView;
        this.aKR = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        this.aKR.handleAction(i, obj);
    }
}
