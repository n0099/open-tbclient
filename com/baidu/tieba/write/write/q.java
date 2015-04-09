package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList cxh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(AtSelectFriendList atSelectFriendList) {
        this.cxh = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean VD;
        r rVar;
        r rVar2;
        linearLayout = this.cxh.bsB;
        linearLayout.removeView(view);
        VD = this.cxh.VD();
        if (!VD) {
            this.cxh.VB();
        }
        rVar = this.cxh.cxg;
        if (rVar != null) {
            rVar2 = this.cxh.cxg;
            rVar2.a(view, view.getTag());
        }
    }
}
