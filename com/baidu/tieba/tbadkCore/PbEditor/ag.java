package com.baidu.tieba.tbadkCore.PbEditor;
/* loaded from: classes.dex */
class ag implements com.baidu.tbadk.editortool.w {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aCI;
    final /* synthetic */ PbEditorToolView bWA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.bWA = pbEditorToolView;
        this.aCI = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        this.aCI.handleAction(i, obj);
    }
}
