package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ b bFQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.bFQ = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter AM;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.bFQ.getData(), null, null);
        AM = this.bFQ.AM();
        AM.dispatchMvcEvent(bVar);
    }
}
