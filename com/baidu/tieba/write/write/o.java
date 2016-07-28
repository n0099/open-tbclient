package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList fTR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.fTR = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean atB;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.fTR.mLayout;
        linearLayout.removeView(view);
        atB = this.fTR.atB();
        if (!atB) {
            this.fTR.atz();
        }
        aVar = this.fTR.fTQ;
        if (aVar != null) {
            aVar2 = this.fTR.fTQ;
            aVar2.a(view, view.getTag());
        }
    }
}
