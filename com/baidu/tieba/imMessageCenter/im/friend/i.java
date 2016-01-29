package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList clg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.clg = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean aha;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.clg.cla;
        linearLayout.removeView(view);
        aha = this.clg.aha();
        if (!aha) {
            this.clg.agY();
        }
        aVar = this.clg.clf;
        if (aVar != null) {
            aVar2 = this.clg.clf;
            aVar2.a(view, view.getTag());
        }
    }
}
