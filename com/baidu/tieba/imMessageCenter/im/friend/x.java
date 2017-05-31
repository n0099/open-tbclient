package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p dkY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.dkY = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.dkY.atJ();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int atK = this.dkY.atK();
                inviteFriendCandidateList = this.dkY.dkO;
                if (atK <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.dkY.dkL;
                    inviteFriendListActivity2 = this.dkY.dkL;
                    String string = inviteFriendListActivity2.getPageContext().getString(w.l.invite_friend_exceed_max_count);
                    i = this.dkY.dkR;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.dkY.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.dkY.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
