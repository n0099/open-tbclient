package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a dke;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.dke = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter FU;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.dke.getData(), null, null);
        FU = this.dke.FU();
        FU.dispatchMvcEvent(bVar);
    }
}
