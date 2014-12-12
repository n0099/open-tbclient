package com.baidu.tieba.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        kVar = this.cft.cfa;
        kVar.setLocationInfoViewState(0);
        aVar.dismiss();
    }
}
