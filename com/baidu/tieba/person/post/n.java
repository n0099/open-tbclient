package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.p;
/* loaded from: classes.dex */
class n implements p.a {
    final /* synthetic */ j ctm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.ctm = jVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        g gVar;
        gVar = this.ctm.ctd;
        gVar.fa(true);
    }
}
