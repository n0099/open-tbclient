package com.baidu.tieba.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.editortool.j jVar;
        jVar = this.bUm.bTT;
        jVar.setLocationInfoViewState(0);
        aVar.dismiss();
    }
}
