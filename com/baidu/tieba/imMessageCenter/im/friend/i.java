package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes2.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList dkv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.dkv = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean ats;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.dkv.mLayout;
        linearLayout.removeView(view);
        ats = this.dkv.ats();
        if (!ats) {
            this.dkv.atq();
        }
        aVar = this.dkv.dku;
        if (aVar != null) {
            aVar2 = this.dkv.dku;
            aVar2.b(view, view.getTag());
        }
    }
}
