package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.tbadkCore.voice.f {
    final /* synthetic */ EditorToolComponetContainer bVZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(EditorToolComponetContainer editorToolComponetContainer) {
        this.bVZ = editorToolComponetContainer;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.f
    public void afY() {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.bVZ.Yg;
        wVar.handleAction(14, null);
        this.bVZ.afy();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.f
    public void Kd() {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.bVZ.Yg;
        wVar.handleAction(15, null);
        this.bVZ.afy();
    }
}
