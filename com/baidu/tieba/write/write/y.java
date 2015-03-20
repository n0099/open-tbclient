package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ x cxf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.cxf = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v vVar;
        w wVar;
        v vVar2;
        w wVar2;
        vVar = this.cxf.cxe;
        wVar = vVar.cwW;
        if (wVar != null) {
            vVar2 = this.cxf.cxe;
            wVar2 = vVar2.cwW;
            wVar2.aqP();
        }
    }
}
