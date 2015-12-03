package com.baidu.tieba.myCollection;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class u implements a.b {
    final /* synthetic */ s cux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.cux = sVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        x xVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        aVar.dismiss();
        xVar = this.cux.cuw;
        aVar2 = this.cux.ctY;
        xVar.jC(aVar2.getOffset());
        aVar3 = this.cux.ctY;
        aVar3.f(true);
    }
}
