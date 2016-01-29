package com.baidu.tieba.myCollection;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class u implements a.b {
    final /* synthetic */ s cFe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.cFe = sVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        x xVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        aVar.dismiss();
        xVar = this.cFe.cFd;
        aVar2 = this.cFe.cEH;
        xVar.kA(aVar2.getOffset());
        aVar3 = this.cFe.cEH;
        aVar3.f(true);
    }
}
