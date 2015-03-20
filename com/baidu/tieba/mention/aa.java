package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ w bDf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar) {
        this.bDf = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter zT;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.bDf.getData(), null, null);
        bVar.setView(this.bDf.getRootView());
        i = this.bDf.position;
        bVar.dL(i);
        zT = this.bDf.zT();
        zT.dispatchMvcEvent(bVar);
    }
}
