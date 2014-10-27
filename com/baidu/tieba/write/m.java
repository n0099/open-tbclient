package com.baidu.tieba.write;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList bSK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtSelectFriendList atSelectFriendList) {
        this.bSK = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean MY;
        n nVar;
        n nVar2;
        linearLayout = this.bSK.mLayout;
        linearLayout.removeView(view);
        MY = this.bSK.MY();
        if (!MY) {
            this.bSK.MW();
        }
        nVar = this.bSK.bSJ;
        if (nVar != null) {
            nVar2 = this.bSK.bSJ;
            nVar2.a(view, view.getTag());
        }
    }
}
