package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class az implements View.OnClickListener {
    final /* synthetic */ av ckB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(av avVar) {
        this.ckB = avVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        be beVar;
        z = this.ckB.ckx;
        if (!z) {
            av avVar = this.ckB;
            beVar = this.ckB.cks;
            avVar.pageNum = beVar.getData().getPage().rO() + 1;
            this.ckB.ckx = true;
            this.ckB.agH();
        }
    }
}
