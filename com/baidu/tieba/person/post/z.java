package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.x;
/* loaded from: classes.dex */
class z implements x.a {
    final /* synthetic */ u cmu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar) {
        this.cmu = uVar;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        p pVar;
        p pVar2;
        pVar = this.cmu.cmr;
        if (pVar != null) {
            pVar2 = this.cmu.cmr;
            pVar2.eR(true);
        }
    }
}
