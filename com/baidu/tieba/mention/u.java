package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ t bsn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bsn = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter wx;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.bsn.getData(), null, null);
        wx = this.bsn.wx();
        wx.dispatchMvcEvent(bVar);
    }
}
