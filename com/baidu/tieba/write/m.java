package com.baidu.tieba.write;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList bSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtSelectFriendList atSelectFriendList) {
        this.bSZ = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean Nc;
        n nVar;
        n nVar2;
        linearLayout = this.bSZ.mLayout;
        linearLayout.removeView(view);
        Nc = this.bSZ.Nc();
        if (!Nc) {
            this.bSZ.Na();
        }
        nVar = this.bSZ.bSY;
        if (nVar != null) {
            nVar2 = this.bSZ.bSY;
            nVar2.a(view, view.getTag());
        }
    }
}
