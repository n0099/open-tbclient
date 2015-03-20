package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b bCH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bCH = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter zT;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.bCH.getData(), null, null);
        zT = this.bCH.zT();
        zT.dispatchMvcEvent(bVar);
    }
}
