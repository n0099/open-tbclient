package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList bvs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(InviteFriendCandidateList inviteFriendCandidateList) {
        this.bvs = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean WV;
        k kVar;
        k kVar2;
        linearLayout = this.bvs.bvm;
        linearLayout.removeView(view);
        WV = this.bvs.WV();
        if (!WV) {
            this.bvs.WT();
        }
        kVar = this.bvs.bvr;
        if (kVar != null) {
            kVar2 = this.bvs.bvr;
            kVar2.a(view, view.getTag());
        }
    }
}
