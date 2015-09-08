package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.x;
/* loaded from: classes.dex */
class n implements x.a {
    final /* synthetic */ j cmb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.cmb = jVar;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        g gVar;
        gVar = this.cmb.clS;
        gVar.eR(true);
    }
}
