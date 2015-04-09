package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.ae;
/* loaded from: classes.dex */
class x implements ae {
    final /* synthetic */ t bSb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.bSb = tVar;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        q qVar;
        q qVar2;
        qVar = this.bSb.bRY;
        if (qVar != null) {
            qVar2 = this.bSb.bRY;
            qVar2.ee(true);
        }
    }
}
