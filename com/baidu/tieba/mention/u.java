package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ t btK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.btK = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter wN;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.btK.getData(), null, null);
        wN = this.btK.wN();
        wN.dispatchMvcEvent(bVar);
    }
}
