package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ aj bQu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(aj ajVar) {
        this.bQu = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        at atVar;
        z = this.bQu.bQr;
        if (!z) {
            aj ajVar = this.bQu;
            atVar = this.bQu.bQm;
            ajVar.pageNum = atVar.getData().XQ().qj() + 1;
            this.bQu.bQr = true;
            this.bQu.adr();
        }
    }
}
