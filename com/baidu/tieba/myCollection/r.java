package com.baidu.tieba.myCollection;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class r implements a.b {
    final /* synthetic */ p ccw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.ccw = pVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        u uVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        aVar.dismiss();
        uVar = this.ccw.ccv;
        aVar2 = this.ccw.cbZ;
        uVar.iL(aVar2.getOffset());
        aVar3 = this.ccw.cbZ;
        aVar3.f(true);
    }
}
