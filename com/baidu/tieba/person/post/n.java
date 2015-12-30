package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.r;
/* loaded from: classes.dex */
class n implements r.a {
    final /* synthetic */ j cVA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.cVA = jVar;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        g gVar;
        gVar = this.cVA.cVr;
        gVar.fG(true);
    }
}
