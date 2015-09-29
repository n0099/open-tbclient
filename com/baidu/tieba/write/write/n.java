package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList dof;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AtSelectFriendList atSelectFriendList) {
        this.dof = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean Zk;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.dof.bMQ;
        linearLayout.removeView(view);
        Zk = this.dof.Zk();
        if (!Zk) {
            this.dof.Zi();
        }
        aVar = this.dof.doe;
        if (aVar != null) {
            aVar2 = this.dof.doe;
            aVar2.a(view, view.getTag());
        }
    }
}
