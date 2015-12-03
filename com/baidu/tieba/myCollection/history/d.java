package com.baidu.tieba.myCollection.history;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ c cuT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cuT = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbHistoryActivity pbHistoryActivity;
        com.baidu.tieba.myCollection.baseHistory.a aVar2;
        pbHistoryActivity = this.cuT.cuS;
        aVar2 = pbHistoryActivity.cuR;
        aVar2.clearCache();
        aVar.dismiss();
    }
}
