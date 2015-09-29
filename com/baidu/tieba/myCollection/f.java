package com.baidu.tieba.myCollection;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class f implements a.b {
    final /* synthetic */ EditMarkActivity cbr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EditMarkActivity editMarkActivity) {
        this.cbr = editMarkActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        j jVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        aVar.dismiss();
        jVar = this.cbr.cbo;
        aVar2 = this.cbr.cbn;
        jVar.iy(aVar2.getOffset());
        aVar3 = this.cbr.cbn;
        aVar3.f(true);
    }
}
