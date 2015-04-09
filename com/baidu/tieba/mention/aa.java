package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ w bDs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar) {
        this.bDs = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter zZ;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.bDs.getData(), null, null);
        bVar.setView(this.bDs.getRootView());
        i = this.bDs.position;
        bVar.dL(i);
        zZ = this.bDs.zZ();
        zZ.dispatchMvcEvent(bVar);
    }
}
