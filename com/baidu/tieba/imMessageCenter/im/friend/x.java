package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p cdh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.cdh = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void handler(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.cdh.acY();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int acZ = this.cdh.acZ();
                inviteFriendCandidateList = this.cdh.ccY;
                if (acZ <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.cdh.ccV;
                    inviteFriendListActivity2 = this.cdh.ccV;
                    String string = inviteFriendListActivity2.getPageContext().getString(n.i.invite_friend_exceed_max_count);
                    i = this.cdh.cdb;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.cdh.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.cdh.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
