package com.baidu.tieba.myCollection;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class r implements a.b {
    final /* synthetic */ p cbV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.cbV = pVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        u uVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        aVar.dismiss();
        uVar = this.cbV.cbU;
        aVar2 = this.cbV.cby;
        uVar.iy(aVar2.getOffset());
        aVar3 = this.cbV.cby;
        aVar3.f(true);
    }
}
