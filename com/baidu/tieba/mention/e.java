package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ b bFP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.bFP = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter AL;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.bFP.getData(), null, null);
        AL = this.bFP.AL();
        AL.dispatchMvcEvent(bVar);
    }
}
