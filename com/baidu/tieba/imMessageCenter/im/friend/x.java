package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p dsB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.dsB = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.dsB.azd();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int aze = this.dsB.aze();
                inviteFriendCandidateList = this.dsB.dsr;
                if (aze <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.dsB.dso;
                    inviteFriendListActivity2 = this.dsB.dso;
                    String string = inviteFriendListActivity2.getPageContext().getString(r.j.invite_friend_exceed_max_count);
                    i = this.dsB.dsu;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.dsB.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.dsB.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
