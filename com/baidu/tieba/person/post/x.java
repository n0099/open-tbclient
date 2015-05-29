package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.aj;
/* loaded from: classes.dex */
class x implements aj {
    final /* synthetic */ t bUI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.bUI = tVar;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        q qVar;
        q qVar2;
        qVar = this.bUI.bUF;
        if (qVar != null) {
            qVar2 = this.bUI.bUF;
            qVar2.eq(true);
        }
    }
}
