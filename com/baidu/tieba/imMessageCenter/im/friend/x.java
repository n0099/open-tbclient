package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.bNJ = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void handler(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.bNJ.Zx();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int Zy = this.bNJ.Zy();
                inviteFriendCandidateList = this.bNJ.bNz;
                if (Zy <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.bNJ.bNw;
                    inviteFriendListActivity2 = this.bNJ.bNw;
                    String string = inviteFriendListActivity2.getPageContext().getString(i.h.invite_friend_exceed_max_count);
                    i = this.bNJ.bND;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.bNJ.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.bNJ.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
