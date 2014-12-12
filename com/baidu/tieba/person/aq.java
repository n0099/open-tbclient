package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {
    final /* synthetic */ am bGm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(am amVar) {
        this.bGm = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        aw awVar;
        z = this.bGm.bGj;
        if (!z) {
            am amVar = this.bGm;
            awVar = this.bGm.bGe;
            amVar.pageNum = awVar.getData().mY().mU() + 1;
            this.bGm.bGj = true;
            this.bGm.aat();
        }
    }
}
