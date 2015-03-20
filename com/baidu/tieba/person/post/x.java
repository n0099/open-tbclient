package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.ae;
/* loaded from: classes.dex */
class x implements ae {
    final /* synthetic */ t bRL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.bRL = tVar;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        q qVar;
        q qVar2;
        qVar = this.bRL.bRI;
        if (qVar != null) {
            qVar2 = this.bRL.bRI;
            qVar2.eg(true);
        }
    }
}
