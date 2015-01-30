package com.baidu.tieba.write;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList cfE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtSelectFriendList atSelectFriendList) {
        this.cfE = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean OJ;
        n nVar;
        n nVar2;
        linearLayout = this.cfE.mLayout;
        linearLayout.removeView(view);
        OJ = this.cfE.OJ();
        if (!OJ) {
            this.cfE.OH();
        }
        nVar = this.cfE.cfD;
        if (nVar != null) {
            nVar2 = this.cfE.cfD;
            nVar2.a(view, view.getTag());
        }
    }
}
