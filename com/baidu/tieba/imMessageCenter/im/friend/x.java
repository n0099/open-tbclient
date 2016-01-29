package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p clJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.clJ = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.clJ.ahr();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int ahs = this.clJ.ahs();
                inviteFriendCandidateList = this.clJ.clA;
                if (ahs <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.clJ.clx;
                    inviteFriendListActivity2 = this.clJ.clx;
                    String string = inviteFriendListActivity2.getPageContext().getString(t.j.invite_friend_exceed_max_count);
                    i = this.clJ.clD;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.clJ.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.clJ.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
