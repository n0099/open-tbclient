package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes2.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList dsr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.dsr = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean axa;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.dsr.mLayout;
        linearLayout.removeView(view);
        axa = this.dsr.axa();
        if (!axa) {
            this.dsr.awY();
        }
        aVar = this.dsr.dsq;
        if (aVar != null) {
            aVar2 = this.dsr.dsq;
            aVar2.b(view, view.getTag());
        }
    }
}
