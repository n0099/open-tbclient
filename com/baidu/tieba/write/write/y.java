package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ x cxy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.cxy = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v vVar;
        w wVar;
        v vVar2;
        w wVar2;
        vVar = this.cxy.cxx;
        wVar = vVar.cxp;
        if (wVar != null) {
            vVar2 = this.cxy.cxx;
            wVar2 = vVar2.cxp;
            wVar2.are();
        }
    }
}
