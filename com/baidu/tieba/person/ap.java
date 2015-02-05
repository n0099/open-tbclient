package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ al bHW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(al alVar) {
        this.bHW = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        av avVar;
        z = this.bHW.bHT;
        if (!z) {
            al alVar = this.bHW;
            avVar = this.bHW.bHO;
            alVar.pageNum = avVar.getData().mT().mP() + 1;
            this.bHW.bHT = true;
            this.bHW.aaT();
        }
    }
}
