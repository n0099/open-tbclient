package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList fQK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.fQK = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean auA;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.fQK.mLayout;
        linearLayout.removeView(view);
        auA = this.fQK.auA();
        if (!auA) {
            this.fQK.auy();
        }
        aVar = this.fQK.fQJ;
        if (aVar != null) {
            aVar2 = this.fQK.fQJ;
            aVar2.a(view, view.getTag());
        }
    }
}
