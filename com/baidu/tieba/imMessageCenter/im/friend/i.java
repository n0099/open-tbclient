package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList dqB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.dqB = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean ayp;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.dqB.mLayout;
        linearLayout.removeView(view);
        ayp = this.dqB.ayp();
        if (!ayp) {
            this.dqB.ayn();
        }
        aVar = this.dqB.dqA;
        if (aVar != null) {
            aVar2 = this.dqB.dqA;
            aVar2.a(view, view.getTag());
        }
    }
}
