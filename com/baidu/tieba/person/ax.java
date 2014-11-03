package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ax implements View.OnClickListener {
    final /* synthetic */ at bCN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(at atVar) {
        this.bCN = atVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        bd bdVar;
        z = this.bCN.bCJ;
        if (!z) {
            at atVar = this.bCN;
            bdVar = this.bCN.bCE;
            atVar.pageNum = bdVar.getData().zO().kf() + 1;
            this.bCN.bCJ = true;
            this.bCN.aac();
        }
    }
}
