package com.baidu.tieba.myCollection;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class f implements a.b {
    final /* synthetic */ EditMarkActivity cbC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EditMarkActivity editMarkActivity) {
        this.cbC = editMarkActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        j jVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        aVar.dismiss();
        jVar = this.cbC.cbz;
        aVar2 = this.cbC.cby;
        jVar.iy(aVar2.getOffset());
        aVar3 = this.cbC.cby;
        aVar3.f(true);
    }
}
