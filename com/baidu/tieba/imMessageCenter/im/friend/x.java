package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p bNy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.bNy = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void handler(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.bNy.ZB();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int ZC = this.bNy.ZC();
                inviteFriendCandidateList = this.bNy.bNo;
                if (ZC <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.bNy.bNl;
                    inviteFriendListActivity2 = this.bNy.bNl;
                    String string = inviteFriendListActivity2.getPageContext().getString(i.h.invite_friend_exceed_max_count);
                    i = this.bNy.bNs;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.bNy.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.bNy.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
