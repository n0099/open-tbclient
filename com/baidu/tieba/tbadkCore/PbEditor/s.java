package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.tbadkCore.voice.f {
    final /* synthetic */ EditorToolComponetContainer bWa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(EditorToolComponetContainer editorToolComponetContainer) {
        this.bWa = editorToolComponetContainer;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.f
    public void agd() {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.bWa.Yj;
        wVar.handleAction(14, null);
        this.bWa.afD();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.f
    public void Ki() {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.bWa.Yj;
        wVar.handleAction(15, null);
        this.bWa.afD();
    }
}
