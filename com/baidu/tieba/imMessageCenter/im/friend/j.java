package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ InviteFriendCandidateList bvt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(InviteFriendCandidateList inviteFriendCandidateList) {
        this.bvt = inviteFriendCandidateList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean WW;
        k kVar;
        k kVar2;
        linearLayout = this.bvt.bvn;
        linearLayout.removeView(view);
        WW = this.bvt.WW();
        if (!WW) {
            this.bvt.WU();
        }
        kVar = this.bvt.bvs;
        if (kVar != null) {
            kVar2 = this.bvt.bvs;
            kVar2.a(view, view.getTag());
        }
    }
}
