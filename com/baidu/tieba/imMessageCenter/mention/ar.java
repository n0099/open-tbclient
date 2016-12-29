package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    final /* synthetic */ ap dcT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar) {
        this.dcT = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter lI;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9485, this.dcT.getData(), null, null);
        lI = this.dcT.lI();
        lI.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10095");
    }
}
