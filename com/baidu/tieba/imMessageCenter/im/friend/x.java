package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p dyg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.dyg = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.dyg.aBa();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int aBb = this.dyg.aBb();
                inviteFriendCandidateList = this.dyg.dxW;
                if (aBb <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.dyg.dxT;
                    inviteFriendListActivity2 = this.dyg.dxT;
                    String string = inviteFriendListActivity2.getPageContext().getString(r.j.invite_friend_exceed_max_count);
                    i = this.dyg.dxZ;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.dyg.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.dyg.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
