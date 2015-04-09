package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.tbadkCore.voice.c {
    final /* synthetic */ EditorToolComponetContainer cmE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EditorToolComponetContainer editorToolComponetContainer) {
        this.cmE = editorToolComponetContainer;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.c
    public void ama() {
        com.baidu.tbadk.editortool.v vVar;
        vVar = this.cmE.aix;
        vVar.handleAction(14, null);
        this.cmE.alA();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.c
    public void NG() {
        com.baidu.tbadk.editortool.v vVar;
        vVar = this.cmE.aix;
        vVar.handleAction(15, null);
        this.cmE.alA();
    }
}
