package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ b brO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.brO = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter wx;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.brO.getData(), null, null);
        wx = this.brO.wx();
        wx.dispatchMvcEvent(bVar);
    }
}
