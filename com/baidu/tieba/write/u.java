package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t cew;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.cew = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        s sVar;
        r rVar2;
        s sVar2;
        rVar = this.cew.cev;
        sVar = rVar.cen;
        if (sVar != null) {
            rVar2 = this.cew.cev;
            sVar2 = rVar2.cen;
            sVar2.ajM();
        }
    }
}
