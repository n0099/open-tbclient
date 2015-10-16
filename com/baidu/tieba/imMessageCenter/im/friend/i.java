package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList bNh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.bNh = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean Zk;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.bNh.bNb;
        linearLayout.removeView(view);
        Zk = this.bNh.Zk();
        if (!Zk) {
            this.bNh.Zi();
        }
        aVar = this.bNh.bNg;
        if (aVar != null) {
            aVar2 = this.bNh.bNg;
            aVar2.a(view, view.getTag());
        }
    }
}
