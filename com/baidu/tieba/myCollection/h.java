package com.baidu.tieba.myCollection;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class h implements a.b {
    final /* synthetic */ EditMarkActivity cEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EditMarkActivity editMarkActivity) {
        this.cEL = editMarkActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        m mVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        aVar.dismiss();
        mVar = this.cEL.cEI;
        aVar2 = this.cEL.cEH;
        mVar.kA(aVar2.getOffset());
        aVar3 = this.cEL.cEH;
        aVar3.f(true);
    }
}
