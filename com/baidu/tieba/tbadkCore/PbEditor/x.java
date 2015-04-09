package com.baidu.tieba.tbadkCore.PbEditor;
/* loaded from: classes.dex */
class x implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIJ;
    final /* synthetic */ PbEditorToolView cng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.v vVar) {
        this.cng = pbEditorToolView;
        this.aIJ = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        this.aIJ.handleAction(i, obj);
    }
}
