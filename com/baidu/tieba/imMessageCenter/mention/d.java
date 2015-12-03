package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ b cef;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.cef = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oM;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.cef.getData(), null, null);
        oM = this.cef.oM();
        oM.dispatchMvcEvent(bVar);
    }
}
