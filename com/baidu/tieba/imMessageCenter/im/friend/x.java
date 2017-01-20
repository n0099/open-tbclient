package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p dis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.dis = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.dis.avD();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int avE = this.dis.avE();
                inviteFriendCandidateList = this.dis.dii;
                if (avE <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.dis.dif;
                    inviteFriendListActivity2 = this.dis.dif;
                    String string = inviteFriendListActivity2.getPageContext().getString(r.l.invite_friend_exceed_max_count);
                    i = this.dis.dil;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.dis.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.dis.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
