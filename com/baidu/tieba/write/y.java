package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.a = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v vVar;
        w wVar;
        v vVar2;
        w wVar2;
        vVar = this.a.a;
        wVar = vVar.d;
        if (wVar != null) {
            vVar2 = this.a.a;
            wVar2 = vVar2.d;
            wVar2.a();
        }
    }
}
