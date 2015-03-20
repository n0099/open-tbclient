package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ w bDf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar) {
        this.bDf = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter zT;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.bDf.getData(), null, null);
        zT = this.bDf.zT();
        zT.dispatchMvcEvent(bVar);
    }
}
