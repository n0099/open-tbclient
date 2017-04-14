package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p djj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.djj = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.djj.auS();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int auT = this.djj.auT();
                inviteFriendCandidateList = this.djj.diZ;
                if (auT <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.djj.diW;
                    inviteFriendListActivity2 = this.djj.diW;
                    String string = inviteFriendListActivity2.getPageContext().getString(w.l.invite_friend_exceed_max_count);
                    i = this.djj.djc;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.djj.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.djj.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
