package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    final /* synthetic */ an dzS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(an anVar) {
        this.dzS = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter lI;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.dzS.getData(), null, null);
        bVar.setView(this.dzS.getRootView());
        i = this.dzS.position;
        bVar.eW(i);
        lI = this.dzS.lI();
        lI.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10096");
    }
}
