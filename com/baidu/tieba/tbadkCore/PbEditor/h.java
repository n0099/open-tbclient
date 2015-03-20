package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.tbadkCore.voice.c {
    final /* synthetic */ EditorToolComponetContainer cmo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EditorToolComponetContainer editorToolComponetContainer) {
        this.cmo = editorToolComponetContainer;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.c
    public void alL() {
        com.baidu.tbadk.editortool.v vVar;
        vVar = this.cmo.aip;
        vVar.handleAction(14, null);
        this.cmo.all();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.c
    public void Nt() {
        com.baidu.tbadk.editortool.v vVar;
        vVar = this.cmo.aip;
        vVar.handleAction(15, null);
        this.cmo.all();
    }
}
