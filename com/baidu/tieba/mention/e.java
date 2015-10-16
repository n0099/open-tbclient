package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ b cai;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.cai = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oF;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.cai.getData(), null, null);
        oF = this.cai.oF();
        oF.dispatchMvcEvent(bVar);
    }
}
