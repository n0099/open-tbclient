package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ w bDs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.bDs = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter zZ;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9485, this.bDs.getData(), null, null);
        zZ = this.bDs.zZ();
        zZ.dispatchMvcEvent(bVar);
    }
}
