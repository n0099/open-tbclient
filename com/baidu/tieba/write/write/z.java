package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ y cBR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.cBR = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        x xVar;
        w wVar2;
        x xVar2;
        wVar = this.cBR.cBQ;
        xVar = wVar.cBI;
        if (xVar != null) {
            wVar2 = this.cBR.cBQ;
            xVar2 = wVar2.cBI;
            xVar2.asV();
        }
    }
}
