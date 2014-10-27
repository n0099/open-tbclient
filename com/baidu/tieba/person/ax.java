package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ax implements View.OnClickListener {
    final /* synthetic */ at bCz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(at atVar) {
        this.bCz = atVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        bd bdVar;
        z = this.bCz.bCv;
        if (!z) {
            at atVar = this.bCz;
            bdVar = this.bCz.bCq;
            atVar.pageNum = bdVar.getData().zM().kf() + 1;
            this.bCz.bCv = true;
            this.bCz.aaa();
        }
    }
}
