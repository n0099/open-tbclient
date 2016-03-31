package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p cwm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.cwm = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.cwm.akL();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int akM = this.cwm.akM();
                inviteFriendCandidateList = this.cwm.cwd;
                if (akM <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.cwm.cwa;
                    inviteFriendListActivity2 = this.cwm.cwa;
                    String string = inviteFriendListActivity2.getPageContext().getString(t.j.invite_friend_exceed_max_count);
                    i = this.cwm.cwg;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.cwm.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.cwm.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
