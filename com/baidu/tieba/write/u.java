package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t cfV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.cfV = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        s sVar;
        r rVar2;
        s sVar2;
        rVar = this.cfV.cfU;
        sVar = rVar.cfM;
        if (sVar != null) {
            rVar2 = this.cfV.cfU;
            sVar2 = rVar2.cfM;
            sVar2.akj();
        }
    }
}
