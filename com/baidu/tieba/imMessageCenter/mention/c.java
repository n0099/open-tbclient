package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes2.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a dgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.dgz = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter EY;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.dgz.getData(), null, null);
        EY = this.dgz.EY();
        EY.dispatchMvcEvent(bVar);
    }
}
