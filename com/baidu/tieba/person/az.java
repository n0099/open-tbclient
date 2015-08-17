package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class az implements View.OnClickListener {
    final /* synthetic */ av cjG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(av avVar) {
        this.cjG = avVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        be beVar;
        z = this.cjG.cjC;
        if (!z) {
            av avVar = this.cjG;
            beVar = this.cjG.cjx;
            avVar.pageNum = beVar.getData().getPage().rR() + 1;
            this.cjG.cjC = true;
            this.cjG.agr();
        }
    }
}
