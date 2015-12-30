package com.baidu.tieba.myCollection;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class u implements a.b {
    final /* synthetic */ s cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.cyx = sVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        x xVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        aVar.dismiss();
        xVar = this.cyx.cyw;
        aVar2 = this.cyx.cya;
        xVar.ka(aVar2.getOffset());
        aVar3 = this.cyx.cya;
        aVar3.f(true);
    }
}
