package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements af {
    final /* synthetic */ t bvW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(t tVar) {
        this.bvW = tVar;
    }

    @Override // com.baidu.tbadk.core.view.af
    public void handler(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.bvW.Xl();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int Xm = this.bvW.Xm();
                inviteFriendCandidateList = this.bvW.bvM;
                if (Xm <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.bvW.bvJ;
                    inviteFriendListActivity2 = this.bvW.bvJ;
                    String string = inviteFriendListActivity2.getPageContext().getString(com.baidu.tieba.t.invite_friend_exceed_max_count);
                    i = this.bvW.bvQ;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.bvW.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.bvW.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
