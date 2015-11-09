package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ b caJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.caJ = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oG;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9485, this.caJ.getData(), null, null);
        oG = this.caJ.oG();
        oG.dispatchMvcEvent(bVar);
    }
}
