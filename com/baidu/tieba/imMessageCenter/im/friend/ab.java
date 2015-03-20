package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.core.view.aa {
    final /* synthetic */ t bsV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(t tVar) {
        this.bsV = tVar;
    }

    @Override // com.baidu.tbadk.core.view.aa
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.bsV.VF();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int VG = this.bsV.VG();
                inviteFriendCandidateList = this.bsV.bsL;
                if (VG <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.bsV.bsI;
                    inviteFriendListActivity2 = this.bsV.bsI;
                    String string = inviteFriendListActivity2.getPageContext().getString(com.baidu.tieba.y.invite_friend_exceed_max_count);
                    i = this.bsV.bsP;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.bsV.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.bsV.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
