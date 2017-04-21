package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ a dmv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dmv = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter FU;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.dmv.getData(), null, null);
        FU = this.dmv.FU();
        FU.dispatchMvcEvent(bVar);
    }
}
