package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p dfE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.dfE = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.dfE.asO();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int asP = this.dfE.asP();
                inviteFriendCandidateList = this.dfE.dfu;
                if (asP <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.dfE.dfr;
                    inviteFriendListActivity2 = this.dfE.dfr;
                    String string = inviteFriendListActivity2.getPageContext().getString(w.l.invite_friend_exceed_max_count);
                    i = this.dfE.dfx;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.dfE.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.dfE.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
