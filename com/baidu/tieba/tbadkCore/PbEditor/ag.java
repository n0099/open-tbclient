package com.baidu.tieba.tbadkCore.PbEditor;
/* loaded from: classes.dex */
class ag implements com.baidu.tbadk.editortool.w {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aBH;
    final /* synthetic */ PbEditorToolView bUI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.bUI = pbEditorToolView;
        this.aBH = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        this.aBH.handleAction(i, obj);
    }
}
