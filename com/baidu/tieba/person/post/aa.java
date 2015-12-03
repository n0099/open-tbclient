package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.q;
/* loaded from: classes.dex */
class aa implements q.a {
    final /* synthetic */ u cRr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.cRr = uVar;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        p pVar;
        p pVar2;
        pVar = this.cRr.cRn;
        if (pVar != null) {
            pVar2 = this.cRr.cRn;
            pVar2.fH(true);
        }
    }
}
