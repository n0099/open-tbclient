package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t bTp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bTp = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        s sVar;
        r rVar2;
        s sVar2;
        rVar = this.bTp.bTo;
        sVar = rVar.bTg;
        if (sVar != null) {
            rVar2 = this.bTp.bTo;
            sVar2 = rVar2.bTg;
            sVar2.afi();
        }
    }
}
