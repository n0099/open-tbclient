package com.baidu.tieba.myCollection;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class h implements a.b {
    final /* synthetic */ EditMarkActivity cuc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EditMarkActivity editMarkActivity) {
        this.cuc = editMarkActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        m mVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        aVar.dismiss();
        mVar = this.cuc.ctZ;
        aVar2 = this.cuc.ctY;
        mVar.jC(aVar2.getOffset());
        aVar3 = this.cuc.ctY;
        aVar3.f(true);
    }
}
