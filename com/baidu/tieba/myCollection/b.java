package com.baidu.tieba.myCollection;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ EditMarkActivity bDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(EditMarkActivity editMarkActivity) {
        this.bDZ = editMarkActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        f fVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        aVar.dismiss();
        fVar = this.bDZ.bDW;
        aVar2 = this.bDZ.bDV;
        fVar.gY(aVar2.getOffset());
        aVar3 = this.bDZ.bDV;
        aVar3.e(true);
    }
}
