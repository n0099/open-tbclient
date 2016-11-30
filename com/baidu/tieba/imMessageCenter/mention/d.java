package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ b dzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.dzg = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter lI;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.dzg.getData(), null, null);
        lI = this.dzg.lI();
        lI.dispatchMvcEvent(bVar);
    }
}
