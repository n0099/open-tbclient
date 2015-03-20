package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIB;
    final /* synthetic */ PbEditorToolView cmQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.v vVar) {
        this.cmQ = pbEditorToolView;
        this.aIB = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        this.aIB.handleAction(i, obj);
    }
}
