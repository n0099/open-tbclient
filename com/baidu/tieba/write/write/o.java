package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList fcx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.fcx = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean akA;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.fcx.cwC;
        linearLayout.removeView(view);
        akA = this.fcx.akA();
        if (!akA) {
            this.fcx.aky();
        }
        aVar = this.fcx.fcw;
        if (aVar != null) {
            aVar2 = this.fcx.fcw;
            aVar2.a(view, view.getTag());
        }
    }
}
