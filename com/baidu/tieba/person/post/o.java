package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.ae;
/* loaded from: classes.dex */
class o implements ae {
    final /* synthetic */ k bRR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.bRR = kVar;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        g gVar;
        gVar = this.bRR.bRJ;
        gVar.ee(true);
    }
}
