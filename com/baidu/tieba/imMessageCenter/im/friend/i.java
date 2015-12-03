package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList ccG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.ccG = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean acH;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.ccG.ccA;
        linearLayout.removeView(view);
        acH = this.ccG.acH();
        if (!acH) {
            this.ccG.acF();
        }
        aVar = this.ccG.ccF;
        if (aVar != null) {
            aVar2 = this.ccG.ccF;
            aVar2.a(view, view.getTag());
        }
    }
}
