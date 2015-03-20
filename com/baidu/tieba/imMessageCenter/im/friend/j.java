package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList bsr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(InviteFriendCandidateList inviteFriendCandidateList) {
        this.bsr = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean Vq;
        k kVar;
        k kVar2;
        linearLayout = this.bsr.bsl;
        linearLayout.removeView(view);
        Vq = this.bsr.Vq();
        if (!Vq) {
            this.bsr.Vo();
        }
        kVar = this.bsr.bsq;
        if (kVar != null) {
            kVar2 = this.bsr.bsq;
            kVar2.a(view, view.getTag());
        }
    }
}
