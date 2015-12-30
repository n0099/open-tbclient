package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p chh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.chh = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void handler(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.chh.aeh();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int aei = this.chh.aei();
                inviteFriendCandidateList = this.chh.cgY;
                if (aei <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.chh.cgV;
                    inviteFriendListActivity2 = this.chh.cgV;
                    String string = inviteFriendListActivity2.getPageContext().getString(n.j.invite_friend_exceed_max_count);
                    i = this.chh.chb;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.chh.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.chh.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
