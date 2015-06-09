package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.tbadkCore.voice.c {
    final /* synthetic */ EditorToolComponetContainer cqE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EditorToolComponetContainer editorToolComponetContainer) {
        this.cqE = editorToolComponetContainer;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.c
    public void anN() {
        com.baidu.tbadk.editortool.v vVar;
        vVar = this.cqE.ajx;
        vVar.handleAction(14, null);
        this.cqE.anm();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.c
    public void OW() {
        com.baidu.tbadk.editortool.v vVar;
        vVar = this.cqE.ajx;
        vVar.handleAction(15, null);
        this.cqE.anm();
    }
}
