package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t cfU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.cfU = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        s sVar;
        r rVar2;
        s sVar2;
        rVar = this.cfU.cfT;
        sVar = rVar.cfL;
        if (sVar != null) {
            rVar2 = this.cfU.cfT;
            sVar2 = rVar2.cfL;
            sVar2.ake();
        }
    }
}
