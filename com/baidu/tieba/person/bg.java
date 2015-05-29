package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ bc bSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bc bcVar) {
        this.bSZ = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        bm bmVar;
        z = this.bSZ.bSW;
        if (!z) {
            bc bcVar = this.bSZ;
            bmVar = this.bSZ.bSR;
            bcVar.pageNum = bmVar.getData().Zp().qP() + 1;
            this.bSZ.bSW = true;
            this.bSZ.aez();
        }
    }
}
