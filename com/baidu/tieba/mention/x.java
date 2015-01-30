package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ t btK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.btK = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter wN;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.btK.getData(), null, null);
        bVar.setView(this.btK.getRootView());
        i = this.btK.position;
        bVar.dI(i);
        wN = this.btK.wN();
        wN.dispatchMvcEvent(bVar);
    }
}
