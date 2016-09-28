package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList drY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.drY = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean ayN;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.drY.mLayout;
        linearLayout.removeView(view);
        ayN = this.drY.ayN();
        if (!ayN) {
            this.drY.ayL();
        }
        aVar = this.drY.drX;
        if (aVar != null) {
            aVar2 = this.drY.drX;
            aVar2.a(view, view.getTag());
        }
    }
}
