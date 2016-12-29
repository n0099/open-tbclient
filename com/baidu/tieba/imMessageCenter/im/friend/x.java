package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p dbf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.dbf = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.dbf.aux();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int auy = this.dbf.auy();
                inviteFriendCandidateList = this.dbf.daV;
                if (auy <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.dbf.daS;
                    inviteFriendListActivity2 = this.dbf.daS;
                    String string = inviteFriendListActivity2.getPageContext().getString(r.j.invite_friend_exceed_max_count);
                    i = this.dbf.daY;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.dbf.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.dbf.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
