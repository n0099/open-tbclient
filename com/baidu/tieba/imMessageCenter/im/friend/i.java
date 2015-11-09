package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList bNC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.bNC = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean ZB;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.bNC.bNw;
        linearLayout.removeView(view);
        ZB = this.bNC.ZB();
        if (!ZB) {
            this.bNC.Zz();
        }
        aVar = this.bNC.bNB;
        if (aVar != null) {
            aVar2 = this.bNC.bNB;
            aVar2.a(view, view.getTag());
        }
    }
}
