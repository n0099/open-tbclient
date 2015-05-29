package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList cBz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(AtSelectFriendList atSelectFriendList) {
        this.cBz = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean WV;
        s sVar;
        s sVar2;
        linearLayout = this.cBz.bvm;
        linearLayout.removeView(view);
        WV = this.cBz.WV();
        if (!WV) {
            this.cBz.WT();
        }
        sVar = this.cBz.cBy;
        if (sVar != null) {
            sVar2 = this.cBz.cBy;
            sVar2.a(view, view.getTag());
        }
    }
}
