package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.p;
/* loaded from: classes.dex */
class n implements p.a {
    final /* synthetic */ j crQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.crQ = jVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        g gVar;
        gVar = this.crQ.crH;
        gVar.eX(true);
    }
}
