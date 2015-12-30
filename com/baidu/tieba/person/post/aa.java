package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.r;
/* loaded from: classes.dex */
class aa implements r.a {
    final /* synthetic */ u cVS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.cVS = uVar;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        p pVar;
        p pVar2;
        pVar = this.cVS.cVP;
        if (pVar != null) {
            pVar2 = this.cVS.cVP;
            pVar2.fG(true);
        }
    }
}
