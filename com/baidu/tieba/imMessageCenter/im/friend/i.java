package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList dkY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.dkY = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean avB;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.dkY.mLayout;
        linearLayout.removeView(view);
        avB = this.dkY.avB();
        if (!avB) {
            this.dkY.avz();
        }
        aVar = this.dkY.dkX;
        if (aVar != null) {
            aVar2 = this.dkY.dkX;
            aVar2.a(view, view.getTag());
        }
    }
}
