package com.baidu.tieba.myCollection;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class h implements a.b {
    final /* synthetic */ EditMarkActivity cye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EditMarkActivity editMarkActivity) {
        this.cye = editMarkActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        m mVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        aVar.dismiss();
        mVar = this.cye.cyb;
        aVar2 = this.cye.cya;
        mVar.ka(aVar2.getOffset());
        aVar3 = this.cye.cya;
        aVar3.f(true);
    }
}
