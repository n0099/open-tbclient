package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p bKt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.bKt = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void handler(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.bKt.YT();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int YU = this.bKt.YU();
                inviteFriendCandidateList = this.bKt.bKj;
                if (YU <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.bKt.bKg;
                    inviteFriendListActivity2 = this.bKt.bKg;
                    String string = inviteFriendListActivity2.getPageContext().getString(i.h.invite_friend_exceed_max_count);
                    i = this.bKt.bKn;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.bKt.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.bKt.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
