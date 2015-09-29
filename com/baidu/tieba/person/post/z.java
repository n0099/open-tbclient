package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.p;
/* loaded from: classes.dex */
class z implements p.a {
    final /* synthetic */ u crX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar) {
        this.crX = uVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        p pVar;
        p pVar2;
        pVar = this.crX.crU;
        if (pVar != null) {
            pVar2 = this.crX.crU;
            pVar2.eX(true);
        }
    }
}
