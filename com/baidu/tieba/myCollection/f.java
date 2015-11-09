package com.baidu.tieba.myCollection;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class f implements a.b {
    final /* synthetic */ EditMarkActivity ccd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EditMarkActivity editMarkActivity) {
        this.ccd = editMarkActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        j jVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        aVar.dismiss();
        jVar = this.ccd.cca;
        aVar2 = this.ccd.cbZ;
        jVar.iL(aVar2.getOffset());
        aVar3 = this.ccd.cbZ;
        aVar3.f(true);
    }
}
