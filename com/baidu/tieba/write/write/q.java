package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList cwO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(AtSelectFriendList atSelectFriendList) {
        this.cwO = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean Vq;
        r rVar;
        r rVar2;
        linearLayout = this.cwO.bsl;
        linearLayout.removeView(view);
        Vq = this.cwO.Vq();
        if (!Vq) {
            this.cwO.Vo();
        }
        rVar = this.cwO.cwN;
        if (rVar != null) {
            rVar2 = this.cwO.cwN;
            rVar2.a(view, view.getTag());
        }
    }
}
