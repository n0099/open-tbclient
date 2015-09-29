package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.p;
/* loaded from: classes.dex */
class n implements p.a {
    final /* synthetic */ j crF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.crF = jVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        g gVar;
        gVar = this.crF.crw;
        gVar.eX(true);
    }
}
