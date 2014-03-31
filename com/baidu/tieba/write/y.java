package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
final class y implements View.OnClickListener {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.a = xVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        w wVar;
        w wVar2;
        wVar = this.a.a.d;
        if (wVar != null) {
            wVar2 = this.a.a.d;
            wVar2.a();
        }
    }
}
