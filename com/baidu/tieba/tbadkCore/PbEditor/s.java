package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.tbadkCore.voice.f {
    final /* synthetic */ EditorToolComponetContainer bUi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(EditorToolComponetContainer editorToolComponetContainer) {
        this.bUi = editorToolComponetContainer;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.f
    public void afz() {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.bUi.XD;
        wVar.handleAction(14, null);
        this.bUi.aeZ();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.f
    public void JN() {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.bUi.XD;
        wVar.handleAction(15, null);
        this.bUi.aeZ();
    }
}
