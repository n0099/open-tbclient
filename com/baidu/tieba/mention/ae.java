package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ aa caz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(aa aaVar) {
        this.caz = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter oF;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.caz.getData(), null, null);
        bVar.setView(this.caz.getRootView());
        i = this.caz.position;
        bVar.eq(i);
        oF = this.caz.oF();
        oF.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10096");
    }
}
