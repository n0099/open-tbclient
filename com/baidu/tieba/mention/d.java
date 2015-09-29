package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ b bZX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.bZX = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oF;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9485, this.bZX.getData(), null, null);
        oF = this.bZX.oF();
        oF.dispatchMvcEvent(bVar);
    }
}
