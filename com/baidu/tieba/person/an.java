package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ aj bQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(aj ajVar) {
        this.bQe = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        at atVar;
        z = this.bQe.bQb;
        if (!z) {
            aj ajVar = this.bQe;
            atVar = this.bQe.bPW;
            ajVar.pageNum = atVar.getData().XE().qj() + 1;
            this.bQe.bQb = true;
            this.bQe.adc();
        }
    }
}
