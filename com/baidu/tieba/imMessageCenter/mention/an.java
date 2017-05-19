package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes2.dex */
class an implements View.OnClickListener {
    final /* synthetic */ am dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.dht = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter EY;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.dht.getData(), null, null);
        EY = this.dht.EY();
        EY.dispatchMvcEvent(bVar);
    }
}
