package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.q;
/* loaded from: classes.dex */
class n implements q.a {
    final /* synthetic */ j cQY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.cQY = jVar;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        g gVar;
        gVar = this.cQY.cQP;
        gVar.fH(true);
    }
}
