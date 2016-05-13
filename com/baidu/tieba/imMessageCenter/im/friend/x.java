package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p cxj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.cxj = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.cxj.akT();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int akU = this.cxj.akU();
                inviteFriendCandidateList = this.cxj.cxa;
                if (akU <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.cxj.cwX;
                    inviteFriendListActivity2 = this.cxj.cwX;
                    String string = inviteFriendListActivity2.getPageContext().getString(t.j.invite_friend_exceed_max_count);
                    i = this.cxj.cxd;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.cxj.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.cxj.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}
