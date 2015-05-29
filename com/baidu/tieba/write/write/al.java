package com.baidu.tieba.write.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.cCP = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.write.editor.b bVar;
        bVar = this.cCP.cCw;
        bVar.setLocationInfoViewState(0);
        aVar.dismiss();
    }
}
