package com.baidu.tieba.myCollection.history;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ c cFA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cFA = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        PbHistoryActivity pbHistoryActivity;
        com.baidu.tieba.myCollection.baseHistory.a aVar2;
        pbHistoryActivity = this.cFA.cFz;
        aVar2 = pbHistoryActivity.cFy;
        aVar2.clearCache();
        aVar.dismiss();
    }
}
