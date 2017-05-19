package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes2.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList dfb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.dfb = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean asw;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.dfb.mLayout;
        linearLayout.removeView(view);
        asw = this.dfb.asw();
        if (!asw) {
            this.dfb.asu();
        }
        aVar = this.dfb.dfa;
        if (aVar != null) {
            aVar2 = this.dfb.dfa;
            aVar2.a(view, view.getTag());
        }
    }
}
