package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p dre;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.dre = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.dre.ayF();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int ayG = this.dre.ayG();
                inviteFriendCandidateList = this.dre.dqU;
                if (ayG <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.dre.dqR;
                    inviteFriendListActivity2 = this.dre.dqR;
                    String string = inviteFriendListActivity2.getPageContext().getString(t.j.invite_friend_exceed_max_count);
                    i = this.dre.dqX;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.dre.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.dre.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
