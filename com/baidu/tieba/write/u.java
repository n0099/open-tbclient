package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        s sVar;
        r rVar2;
        s sVar2;
        rVar = this.a.a;
        sVar = rVar.d;
        if (sVar != null) {
            rVar2 = this.a.a;
            sVar2 = rVar2.d;
            sVar2.a();
        }
    }
}
