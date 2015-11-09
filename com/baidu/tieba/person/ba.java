package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ba implements View.OnClickListener {
    final /* synthetic */ aw crM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(aw awVar) {
        this.crM = awVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        bf bfVar;
        z = this.crM.crI;
        if (!z) {
            aw awVar = this.crM;
            bfVar = this.crM.crD;
            awVar.pageNum = bfVar.getData().getPage().rI() + 1;
            this.crM.crI = true;
            this.crM.ajj();
        }
    }
}
