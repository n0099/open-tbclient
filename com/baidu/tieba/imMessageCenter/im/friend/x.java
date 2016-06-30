package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p dcA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.dcA = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.dcA.atf();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int atg = this.dcA.atg();
                inviteFriendCandidateList = this.dcA.dcp;
                if (atg <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.dcA.dcm;
                    inviteFriendListActivity2 = this.dcA.dcm;
                    String string = inviteFriendListActivity2.getPageContext().getString(u.j.invite_friend_exceed_max_count);
                    i = this.dcA.dcs;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.dcA.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.dcA.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
