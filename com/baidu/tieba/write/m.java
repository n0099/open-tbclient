package com.baidu.tieba.write;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList cfD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtSelectFriendList atSelectFriendList) {
        this.cfD = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean OE;
        n nVar;
        n nVar2;
        linearLayout = this.cfD.mLayout;
        linearLayout.removeView(view);
        OE = this.cfD.OE();
        if (!OE) {
            this.cfD.OC();
        }
        nVar = this.cfD.cfC;
        if (nVar != null) {
            nVar2 = this.cfD.cfC;
            nVar2.a(view, view.getTag());
        }
    }
}
