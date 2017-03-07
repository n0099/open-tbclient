package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p dkK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.dkK = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.dkK.auZ();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int ava = this.dkK.ava();
                inviteFriendCandidateList = this.dkK.dkA;
                if (ava <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.dkK.dkx;
                    inviteFriendListActivity2 = this.dkK.dkx;
                    String string = inviteFriendListActivity2.getPageContext().getString(w.l.invite_friend_exceed_max_count);
                    i = this.dkK.dkD;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.dkK.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.dkK.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
