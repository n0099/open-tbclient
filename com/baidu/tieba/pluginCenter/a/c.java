package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a bXK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bXK = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter AM;
        ViewEventCenter AM2;
        AM = this.bXK.AM();
        if (AM != null) {
            AM2 = this.bXK.AM();
            AM2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, this.bXK.getData(), null, null));
        }
    }
}
