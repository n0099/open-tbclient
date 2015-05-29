package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.tbadkCore.voice.c {
    final /* synthetic */ EditorToolComponetContainer cqD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EditorToolComponetContainer editorToolComponetContainer) {
        this.cqD = editorToolComponetContainer;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.c
    public void anM() {
        com.baidu.tbadk.editortool.v vVar;
        vVar = this.cqD.ajx;
        vVar.handleAction(14, null);
        this.cqD.anl();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.c
    public void OV() {
        com.baidu.tbadk.editortool.v vVar;
        vVar = this.cqD.ajx;
        vVar.handleAction(15, null);
        this.cqD.anl();
    }
}
