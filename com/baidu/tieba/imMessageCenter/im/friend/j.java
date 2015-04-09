package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList bsH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(InviteFriendCandidateList inviteFriendCandidateList) {
        this.bsH = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean VD;
        k kVar;
        k kVar2;
        linearLayout = this.bsH.bsB;
        linearLayout.removeView(view);
        VD = this.bsH.VD();
        if (!VD) {
            this.bsH.VB();
        }
        kVar = this.bsH.bsG;
        if (kVar != null) {
            kVar2 = this.bsH.bsG;
            kVar2.a(view, view.getTag());
        }
    }
}
