package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.x;
/* loaded from: classes.dex */
class t implements x.a {
    final /* synthetic */ p clq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.clq = pVar;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        o oVar;
        o oVar2;
        oVar = this.clq.cln;
        if (oVar != null) {
            oVar2 = this.clq.cln;
            oVar2.eI(true);
        }
    }
}
