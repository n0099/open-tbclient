package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.aj;
/* loaded from: classes.dex */
class o implements aj {
    final /* synthetic */ k bUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.bUz = kVar;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        g gVar;
        gVar = this.bUz.bUr;
        gVar.eq(true);
    }
}
