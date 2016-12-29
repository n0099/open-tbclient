package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ b dca;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.dca = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter lI;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.dca.getData(), null, null);
        lI = this.dca.lI();
        lI.dispatchMvcEvent(bVar);
    }
}
