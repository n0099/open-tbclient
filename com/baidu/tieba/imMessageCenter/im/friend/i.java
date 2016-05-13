package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList cwH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.cwH = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean akC;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.cwH.cwC;
        linearLayout.removeView(view);
        akC = this.cwH.akC();
        if (!akC) {
            this.cwH.akA();
        }
        aVar = this.cwH.cwG;
        if (aVar != null) {
            aVar2 = this.cwH.cwG;
            aVar2.a(view, view.getTag());
        }
    }
}
