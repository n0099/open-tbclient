package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ t btJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.btJ = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter wH;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.btJ.getData(), null, null);
        wH = this.btJ.wH();
        wH.dispatchMvcEvent(bVar);
    }
}
