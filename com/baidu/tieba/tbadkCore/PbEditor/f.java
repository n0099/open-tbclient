package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ EditorToolComponetContainer cmo;
    private final /* synthetic */ com.baidu.tbadk.editortool.v cmp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EditorToolComponetContainer editorToolComponetContainer, com.baidu.tbadk.editortool.v vVar) {
        this.cmo = editorToolComponetContainer;
        this.cmp = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        if (i == 46) {
            this.cmo.clQ.yR();
        } else if (i == 47) {
            this.cmo.clQ.yS();
        }
        this.cmp.handleAction(i, obj);
    }
}
