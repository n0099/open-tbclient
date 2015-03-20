package com.baidu.tieba.write.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.cyc = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.write.editor.b bVar;
        bVar = this.cyc.cxJ;
        bVar.setLocationInfoViewState(0);
        aVar.dismiss();
    }
}
