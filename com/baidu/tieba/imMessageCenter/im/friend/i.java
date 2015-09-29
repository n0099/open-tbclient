package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList bMW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.bMW = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean Zk;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.bMW.bMQ;
        linearLayout.removeView(view);
        Zk = this.bMW.Zk();
        if (!Zk) {
            this.bMW.Zi();
        }
        aVar = this.bMW.bMV;
        if (aVar != null) {
            aVar2 = this.bMW.bMV;
            aVar2.a(view, view.getTag());
        }
    }
}
