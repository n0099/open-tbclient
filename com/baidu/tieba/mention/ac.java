package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ aa caz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar) {
        this.caz = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oF;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9485, this.caz.getData(), null, null);
        oF = this.caz.oF();
        oF.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10095");
    }
}
