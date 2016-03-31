package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a dSd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.dSd = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oy;
        ViewEventCenter oy2;
        oy = this.dSd.oy();
        if (oy != null) {
            oy2 = this.dSd.oy();
            oy2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, this.dSd.getData(), null, null));
        }
    }
}
