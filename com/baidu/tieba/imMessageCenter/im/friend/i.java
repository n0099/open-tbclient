package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList bJR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.bJR = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean YC;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.bJR.bJL;
        linearLayout.removeView(view);
        YC = this.bJR.YC();
        if (!YC) {
            this.bJR.YA();
        }
        aVar = this.bJR.bJQ;
        if (aVar != null) {
            aVar2 = this.bJR.bJQ;
            aVar2.a(view, view.getTag());
        }
    }
}
