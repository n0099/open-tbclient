package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList dbW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.dbW = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean asP;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.dbW.mLayout;
        linearLayout.removeView(view);
        asP = this.dbW.asP();
        if (!asP) {
            this.dbW.asN();
        }
        aVar = this.dbW.dbV;
        if (aVar != null) {
            aVar2 = this.dbW.dbV;
            aVar2.a(view, view.getTag());
        }
    }
}
