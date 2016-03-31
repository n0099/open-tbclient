package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList cvK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.cvK = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean aku;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.cvK.cvF;
        linearLayout.removeView(view);
        aku = this.cvK.aku();
        if (!aku) {
            this.cvK.aks();
        }
        aVar = this.cvK.cvJ;
        if (aVar != null) {
            aVar2 = this.cvK.cvJ;
            aVar2.a(view, view.getTag());
        }
    }
}
