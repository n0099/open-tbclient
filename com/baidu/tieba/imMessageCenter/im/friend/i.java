package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList dxE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.dxE = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean aAK;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.dxE.mLayout;
        linearLayout.removeView(view);
        aAK = this.dxE.aAK();
        if (!aAK) {
            this.dxE.aAI();
        }
        aVar = this.dxE.dxD;
        if (aVar != null) {
            aVar2 = this.dxE.dxD;
            aVar2.a(view, view.getTag());
        }
    }
}
