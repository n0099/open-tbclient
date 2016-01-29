package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList erP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AtSelectFriendList atSelectFriendList) {
        this.erP = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean aha;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.erP.cla;
        linearLayout.removeView(view);
        aha = this.erP.aha();
        if (!aha) {
            this.erP.agY();
        }
        aVar = this.erP.erO;
        if (aVar != null) {
            aVar2 = this.erP.erO;
            aVar2.a(view, view.getTag());
        }
    }
}
