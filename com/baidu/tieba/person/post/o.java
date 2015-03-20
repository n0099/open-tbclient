package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.ae;
/* loaded from: classes.dex */
class o implements ae {
    final /* synthetic */ k bRB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.bRB = kVar;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        g gVar;
        gVar = this.bRB.bRt;
        gVar.eg(true);
    }
}
