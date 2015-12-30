package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList cgG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.cgG = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean adQ;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.cgG.cgA;
        linearLayout.removeView(view);
        adQ = this.cgG.adQ();
        if (!adQ) {
            this.cgG.adO();
        }
        aVar = this.cgG.cgF;
        if (aVar != null) {
            aVar2 = this.cgG.cgF;
            aVar2.a(view, view.getTag());
        }
    }
}
