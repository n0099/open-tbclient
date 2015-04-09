package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.core.view.aa {
    final /* synthetic */ t btl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(t tVar) {
        this.btl = tVar;
    }

    @Override // com.baidu.tbadk.core.view.aa
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.btl.VS();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int VT = this.btl.VT();
                inviteFriendCandidateList = this.btl.btb;
                if (VT <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.btl.bsY;
                    inviteFriendListActivity2 = this.btl.bsY;
                    String string = inviteFriendListActivity2.getPageContext().getString(com.baidu.tieba.y.invite_friend_exceed_max_count);
                    i = this.btl.btf;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.btl.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.btl.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
