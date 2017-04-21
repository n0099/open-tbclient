package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p dlA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.dlA = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.dlA.avT();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int avU = this.dlA.avU();
                inviteFriendCandidateList = this.dlA.dlq;
                if (avU <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.dlA.dln;
                    inviteFriendListActivity2 = this.dlA.dln;
                    String string = inviteFriendListActivity2.getPageContext().getString(w.l.invite_friend_exceed_max_count);
                    i = this.dlA.dlt;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.dlA.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.dlA.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
