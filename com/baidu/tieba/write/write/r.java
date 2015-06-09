package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList cBA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(AtSelectFriendList atSelectFriendList) {
        this.cBA = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean WW;
        s sVar;
        s sVar2;
        linearLayout = this.cBA.bvn;
        linearLayout.removeView(view);
        WW = this.cBA.WW();
        if (!WW) {
            this.cBA.WU();
        }
        sVar = this.cBA.cBz;
        if (sVar != null) {
            sVar2 = this.cBA.cBz;
            sVar2.a(view, view.getTag());
        }
    }
}
