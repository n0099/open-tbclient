package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements af {
    final /* synthetic */ t bvV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(t tVar) {
        this.bvV = tVar;
    }

    @Override // com.baidu.tbadk.core.view.af
    public void handler(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.bvV.Xk();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int Xl = this.bvV.Xl();
                inviteFriendCandidateList = this.bvV.bvL;
                if (Xl <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.bvV.bvI;
                    inviteFriendListActivity2 = this.bvV.bvI;
                    String string = inviteFriendListActivity2.getPageContext().getString(com.baidu.tieba.t.invite_friend_exceed_max_count);
                    i = this.bvV.bvP;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.bvV.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.bvV.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
