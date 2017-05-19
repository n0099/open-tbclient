package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList fRk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.fRk = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean asw;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.fRk.mLayout;
        linearLayout.removeView(view);
        asw = this.fRk.asw();
        if (!asw) {
            this.fRk.asu();
        }
        aVar = this.fRk.fRj;
        if (aVar != null) {
            aVar2 = this.fRk.fRj;
            aVar2.a(view, view.getTag());
        }
    }
}
