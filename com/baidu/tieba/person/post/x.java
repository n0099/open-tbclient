package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.aj;
/* loaded from: classes.dex */
class x implements aj {
    final /* synthetic */ t bUJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.bUJ = tVar;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        q qVar;
        q qVar2;
        qVar = this.bUJ.bUG;
        if (qVar != null) {
            qVar2 = this.bUJ.bUG;
            qVar2.eq(true);
        }
    }
}
