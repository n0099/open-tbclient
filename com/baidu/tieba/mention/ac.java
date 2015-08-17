package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ z bWf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.bWf = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oH;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.bWf.getData(), null, null);
        oH = this.bWf.oH();
        oH.dispatchMvcEvent(bVar);
    }
}
