package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p bJM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.bJM = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void handler(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.bJM.YR();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int YS = this.bJM.YS();
                inviteFriendCandidateList = this.bJM.bJC;
                if (YS <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.bJM.bJz;
                    inviteFriendListActivity2 = this.bJM.bJz;
                    String string = inviteFriendListActivity2.getPageContext().getString(i.C0057i.invite_friend_exceed_max_count);
                    i = this.bJM.bJG;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.bJM.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.bJM.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
