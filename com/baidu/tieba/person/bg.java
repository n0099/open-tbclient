package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ bc bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bc bcVar) {
        this.bTa = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        bm bmVar;
        z = this.bTa.bSX;
        if (!z) {
            bc bcVar = this.bTa;
            bmVar = this.bTa.bSS;
            bcVar.pageNum = bmVar.getData().Zq().qP() + 1;
            this.bTa.bSX = true;
            this.bTa.aeA();
        }
    }
}
