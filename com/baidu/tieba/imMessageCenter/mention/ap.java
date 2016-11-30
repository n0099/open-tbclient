package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ an dzS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(an anVar) {
        this.dzS = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter lI;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9485, this.dzS.getData(), null, null);
        lI = this.dzS.lI();
        lI.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10095");
    }
}
