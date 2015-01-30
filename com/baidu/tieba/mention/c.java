package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b btk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.btk = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter wN;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.btk.getData(), null, null);
        wN = this.btk.wN();
        wN.dispatchMvcEvent(bVar);
    }
}
