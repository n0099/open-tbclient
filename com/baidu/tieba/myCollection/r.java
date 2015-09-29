package com.baidu.tieba.myCollection;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class r implements a.b {
    final /* synthetic */ p cbK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.cbK = pVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        u uVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        aVar.dismiss();
        uVar = this.cbK.cbJ;
        aVar2 = this.cbK.cbn;
        uVar.iy(aVar2.getOffset());
        aVar3 = this.cbK.cbn;
        aVar3.f(true);
    }
}
