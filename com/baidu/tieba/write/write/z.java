package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ y cBQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.cBQ = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        x xVar;
        w wVar2;
        x xVar2;
        wVar = this.cBQ.cBP;
        xVar = wVar.cBH;
        if (xVar != null) {
            wVar2 = this.cBQ.cBP;
            xVar2 = wVar2.cBH;
            xVar2.asU();
        }
    }
}
