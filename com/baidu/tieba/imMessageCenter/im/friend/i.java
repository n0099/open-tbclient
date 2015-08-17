package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList bJk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.bJk = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean YA;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.bJk.bJe;
        linearLayout.removeView(view);
        YA = this.bJk.YA();
        if (!YA) {
            this.bJk.Yy();
        }
        aVar = this.bJk.bJj;
        if (aVar != null) {
            aVar2 = this.bJk.bJj;
            aVar2.a(view, view.getTag());
        }
    }
}
