package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ aa cbl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(aa aaVar) {
        this.cbl = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter oG;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.cbl.getData(), null, null);
        bVar.setView(this.cbl.getRootView());
        i = this.cbl.position;
        bVar.eo(i);
        oG = this.cbl.oG();
        oG.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10096");
    }
}
