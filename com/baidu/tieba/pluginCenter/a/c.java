package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a djD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.djD = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter ok;
        ViewEventCenter ok2;
        ok = this.djD.ok();
        if (ok != null) {
            ok2 = this.djD.ok();
            ok2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, this.djD.getData(), null, null));
        }
    }
}
