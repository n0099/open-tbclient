package com.baidu.tieba.tbadkCore.PbEditor;
/* loaded from: classes.dex */
class ag implements com.baidu.tbadk.editortool.w {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aCF;
    final /* synthetic */ PbEditorToolView bWz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.bWz = pbEditorToolView;
        this.aCF = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        this.aCF.handleAction(i, obj);
    }
}
