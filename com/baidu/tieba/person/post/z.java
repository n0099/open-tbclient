package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.p;
/* loaded from: classes.dex */
class z implements p.a {
    final /* synthetic */ u ctE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar) {
        this.ctE = uVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        p pVar;
        p pVar2;
        pVar = this.ctE.ctB;
        if (pVar != null) {
            pVar2 = this.ctE.ctB;
            pVar2.fa(true);
        }
    }
}
