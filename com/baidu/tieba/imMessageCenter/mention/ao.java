package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes2.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ am dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar) {
        this.dht = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter EY;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9485, this.dht.getData(), null, null);
        EY = this.dht.EY();
        EY.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10095");
    }
}
