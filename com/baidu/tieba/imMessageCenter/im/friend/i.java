package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList dhQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(InviteFriendCandidateList inviteFriendCandidateList) {
        this.dhQ = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean avm;
        InviteFriendCandidateList.a aVar;
        InviteFriendCandidateList.a aVar2;
        linearLayout = this.dhQ.mLayout;
        linearLayout.removeView(view);
        avm = this.dhQ.avm();
        if (!avm) {
            this.dhQ.avk();
        }
        aVar = this.dhQ.dhP;
        if (aVar != null) {
            aVar2 = this.dhQ.dhP;
            aVar2.a(view, view.getTag());
        }
    }
}
