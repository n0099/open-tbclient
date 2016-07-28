package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p dfx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.dfx = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.dfx.atR();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int atS = this.dfx.atS();
                inviteFriendCandidateList = this.dfx.dfn;
                if (atS <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.dfx.dfk;
                    inviteFriendListActivity2 = this.dfx.dfk;
                    String string = inviteFriendListActivity2.getPageContext().getString(u.j.invite_friend_exceed_max_count);
                    i = this.dfx.dfq;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.dfx.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.dfx.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
